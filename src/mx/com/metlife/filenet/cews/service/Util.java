package mx.com.metlife.filenet.cews.service;

import com.filenet.api.constants.Cardinality;
import com.filenet.api.constants.TypeID;
import com.filenet.api.core.ContentTransfer;
import com.filenet.api.core.Factory.Folder;
import com.filenet.wcm.api.BadReferenceException;
import com.filenet.wcm.api.BaseRuntimeException;
import com.filenet.wcm.api.Document;
import com.filenet.wcm.api.InvalidContentEngineClassException;
import com.filenet.wcm.api.InvalidCredentialsException;
import com.filenet.wcm.api.ReadOnlyObjectException;
import com.filenet.wcm.api.RemoteServerException;
import com.filenet.wcm.api.TransportInputStream;
import com.filenet.wcm.api.UniquenessConstraintException;
import com.intent.admin.filenetp8.UtilFilenetP8;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import mx.com.metlife.encrypt.Blowfish;
import mx.com.metlife.filenet.cews.WSDLFile.*;
import mx.com.metlife.filenet.utils.MetaData;
import mx.com.metlife.filenet.utils.MetaDataList;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public class Util {
	private final Blowfish blowfish = new Blowfish();
	private final Logger log = Logger.getLogger(getClass());
	private String validation_msg = "";

	public final SearchDocRs executeSearch(SearchDocRq paramSearchDocRq) {
		this.log.debug("Start query");
		SearchDocRs localSearchDocRs = new SearchDocRs();
		try {
			this.log.debug("Validate User");
			String str1 = decode(paramSearchDocRq.getUser());
			if (!validateParameter(str1)) {
				localSearchDocRs.setOperationStatCd("010");
				localSearchDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter User can't be empty ");
				return localSearchDocRs;
			}
			this.log.debug("Validate Password");
			String localObject1 = decode(paramSearchDocRq.getPassword());
			if (!validateParameter((String) localObject1)) {
				localSearchDocRs.setOperationStatCd("010");
				localSearchDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Password can't be empty ");
				return localSearchDocRs;
			}
			// localObject1 = this.blowfish.decode((String) localObject1);
			this.log.debug("Validate ObjectStore");
			String str2 = decode(paramSearchDocRq.getObjectStore());
			if (!validateParameter(str2)) {
				localSearchDocRs.setOperationStatCd("010");
				localSearchDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter ObjectStore can't be empty ");
				return localSearchDocRs;
			}
			this.log.debug("Validate DocClass");
			String str3 = decode(paramSearchDocRq.getDocClass());
			if (!validateParameter(str3)) {
				localSearchDocRs.setOperationStatCd("010");
				localSearchDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter DocClass can't be empty ");
				return localSearchDocRs;
			}
			String str4 = "";
			this.log.debug("Validate Path");
			if (paramSearchDocRq.getPath() != null) {
				str4 = decode(paramSearchDocRq.getPath());
			}
			this.log.debug("Validate QueryCondition");
			String str5 = decode(paramSearchDocRq.getQueryCondition());
			if (!validateParameter(str5)) {
				localSearchDocRs.setOperationStatCd("010");
				localSearchDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter QueryCondition can't be empty ");
				return localSearchDocRs;
			}
			if (str5.trim().length() == 0) {
				str5 = "Id = Id ";
			}
			this.log.debug("Params");
			this.log.debug(str1 + "--" + str2 + "--" + str3 + "--" + str4 + "--" + str5);
			UtilFilenetP8 localUtilFilenetP8 = new UtilFilenetP8(str1, (String) localObject1, str2);
			UtilFilenetP8.setFormatDate(ResourceBundle.getBundle("WcmApiConfig").getString("DATEFORMAT"));
			UtilFilenetP8.setPatternDate(ResourceBundle.getBundle("WcmApiConfig").getString("DATEPATTERN"));
			UtilFilenetP8.setTimeZone(ResourceBundle.getBundle("WcmApiConfig").getString("TIMEZONE"));
			localUtilFilenetP8.setMultivalueSplit(ResourceBundle.getBundle("WcmApiConfig").getString("SPLITCHARACTER"));
			HashMap localHashMap1 = localUtilFilenetP8.getPropertyDefinitionsByClass(str3);
			List localList1 = getDateProperties(localHashMap1);
			String str6 = "";
			if ((str4 != null) && (str4.trim().length() > 0)) {
				str6 = "  " + str3 + ".This INFOLDER '" + str4 + "' AND ";
			}
			String str7 = "SELECT " + fixParams(localHashMap1) + " FROM ";
			str7 = str7 + str3 + " WHERE " + "VersionStatus" + "= 1 " + " AND " + str6 + parseCharacters(str5);
			String where = "VersionStatus" + "= 1 " + " AND " + str6 + parseCharacters(str5);
			this.log.debug("Query : " + str7);
			List localList2 = localUtilFilenetP8.query(fixParams(localHashMap1), str3, where);
			this.log.debug("Results : ".concat(String.valueOf(localList2.size())));
			String[] arrayOfString = fixParams(localHashMap1).split(",");
			Metadata[][] arrayOfMetadata = new Metadata[localList2.size()][];
			int i = localList2.size();
			for (int j = 0; j < i; j++) {
				HashMap localHashMap2 = (HashMap) localList2.get(j);
				Metadata[] arrayOfMetadata1 = new Metadata[arrayOfString.length];
				for (int k = 0; k < arrayOfString.length; k++) {
					Metadata localMetadata = new Metadata();
					Object localObject2 = localHashMap2.get(arrayOfString[k]);
					if (localList1.contains(arrayOfString[k])) {
						try {
							localObject2 = UtilFilenetP8.getFormatDate().format((Date) localObject2);
						} catch (Exception localException2) {
						}
					}
					if (arrayOfString[k].equals("Id")) {
						localMetadata.setKey("GUID".getBytes());
					} else {
						localMetadata.setKey(arrayOfString[k].getBytes());
					}
					if (localHashMap2.get(arrayOfString[k]) != null) {
						localMetadata.setValue(localObject2.toString().getBytes());
					} else {
						localMetadata.setValue("".toString().getBytes());
					}
					arrayOfMetadata1[k] = localMetadata;
				}
				arrayOfMetadata[j] = arrayOfMetadata1;
			}
			localSearchDocRs.setDocuments(arrayOfMetadata);
			localSearchDocRs.setErrStatDesc("");
			localSearchDocRs.setOperationStatCd("000");
			if (localList2.size() == 0) {
				localSearchDocRs.setErrStatDesc("CONTENTENGINE_FILE_NOT_FOUND The query did not match any documents.");
				localSearchDocRs.setOperationStatCd("005");
			}
		} catch (Exception localException1) {
			Object localObject1 = evaluateException(localException1);
			localSearchDocRs.setOperationStatCd(((ResponseError) localObject1).getErrCd());
			localSearchDocRs.setErrStatDesc(((ResponseError) localObject1).getErrStat());
		}
		return localSearchDocRs;
	}

	private String decode(byte[] paramArrayOfByte) {
		if (paramArrayOfByte != null) {
			return new String(paramArrayOfByte);
		}
		return null;
	}

	private String fixParams(HashMap paramHashMap) {
		String str1 = "";
		Iterator localIterator = paramHashMap.keySet().iterator();
		while (localIterator.hasNext()) {
			String str2 = (String) localIterator.next();
			HashMap localHashMap = (HashMap) paramHashMap.get(str2);
			if (((localHashMap.get("Cardinality")) == Cardinality.SINGLE)
					&& (!"SourceDocument".equals(localHashMap.get("SymbolicName").toString()))) {
				str1 = str1 + localHashMap.get("SymbolicName").toString().concat(",");
			}
		}
		str1 = str1 + "Id,";
		str1 = str1 + "DateCreated,";
		str1 = str1 + "DateLastModified,";
		str1 = str1 + "LastModifier";
		this.log.debug("PARAM " + str1);
		return str1;
	}

	private List getDateProperties(HashMap paramHashMap) {
		ArrayList localArrayList = new ArrayList();
		Iterator localIterator = paramHashMap.keySet().iterator();
		while (localIterator.hasNext()) {
			String str = (String) localIterator.next();
			HashMap localHashMap = (HashMap) paramHashMap.get(str);
			if (localHashMap.get("DataType") == TypeID.DATE) {
				localArrayList.add(localHashMap.get("SymbolicName").toString());
			}
		}
		localArrayList.add("DateCreated");
		localArrayList.add("DateLastModified");
		return localArrayList;
	}

	public final InsertDocRs executeInsert(InsertDocRq paramInsertDocRq) {
		this.log.debug("Start insert: ");
		InsertDocRs localInsertDocRs = new InsertDocRs();
		try {
			ResourceBundle localResourceBundle = ResourceBundle.getBundle("WcmApiConfig");
			this.log.debug("Validate USERCONTENT");
			if (!validateParameter(localResourceBundle.getString("USERCONTENT"))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter User can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate PASSWORDCONTENT");
			// if
			// (!validateParameter(this.blowfish.decode(localResourceBundle.getString("PASSWORDCONTENT"))))
			// {
			if (!validateParameter((localResourceBundle.getString("PASSWORDCONTENT")))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Password can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate ObjectStore");
			if (!validateParameter(decode(paramInsertDocRq.getObjectStore()))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter ObjectStore can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Duplicate");
			if (!validateParameter(decode(paramInsertDocRq.getDuplicate()))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Duplicate can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Path");
			if (!validateParameter(decode(paramInsertDocRq.getPath()))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Path can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate DocClass");
			String docClass = decode(paramInsertDocRq.getDocClass());
			if (!validateParameter(docClass)) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter DocClass can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Content");
			if (!validateParameter(decode(paramInsertDocRq.getContent()))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Content can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Filenm");
			String fName = decode(paramInsertDocRq.getFilenm());
			String tmpdir = System.getProperty("java.io.tmpdir");
			fName = tmpdir + java.io.File.separator + fName;
			if (!validateParameter(fName)) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Filenm can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Properties");
			if ((paramInsertDocRq.getProperties() == null) || (paramInsertDocRq.getProperties().length == 0)) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Properties can't be null or empty ");
				return localInsertDocRs;
			}
			Base64 localBase64 = new Base64();
			UtilFilenetP8 localObject1 = new UtilFilenetP8(localResourceBundle.getString("USERCONTENT"),
					// this.blowfish.decode(localResourceBundle.getString("PASSWORDCONTENT")),
					decode(localBase64.decode(localResourceBundle.getString("PASSWORDCONTENT").getBytes())),
					decode(paramInsertDocRq.getObjectStore()));
			UtilFilenetP8.setFormatDate(ResourceBundle.getBundle("WcmApiConfig").getString("DATEFORMAT"));
			UtilFilenetP8.setPatternDate(ResourceBundle.getBundle("WcmApiConfig").getString("DATEPATTERN"));
			UtilFilenetP8.setTimeZone(ResourceBundle.getBundle("WcmApiConfig").getString("TIMEZONE"));
			localObject1.setMultivalueSplit(ResourceBundle.getBundle("WcmApiConfig").getString("SPLITCHARACTER"));
			byte[] arrayOfByte = paramInsertDocRq.getContent();
			if (writeFile(arrayOfByte, fName)) {
				this.log.debug("Temp Document created: " + fName);
				ArrayList localArrayList1 = new ArrayList();
				ArrayList localArrayList2 = new ArrayList();
				int i = 0;
				for (int j = 0; j < paramInsertDocRq.getProperties().length; j++) {
					Metadata localObject2 = paramInsertDocRq.getProperties()[j];
					if (localObject2 == null) {
						localInsertDocRs.setOperationStatCd("010");
						localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Metadata Tag must have parameters");
						return localInsertDocRs;
					}
					String localObject3 = decode(((Metadata) localObject2).getKey());
					String str2 = decode(((Metadata) localObject2).getValue());

					if ((str2 != null) && (localObject3 != null) && (((String) localObject3).length() > 0)
							&& (fName != null)) {
						if ((str2 != null) && (str2.length() == 0)
								&& (((String) localObject3).equals("DocumentTitle"))) {
							str2 = fName;
						}
						localArrayList1.add(localObject3);
						localArrayList2.add(str2);
						if (((String) localObject3).equals("DocumentTitle")) {
							i = 1;
						}
					} else {
						localInsertDocRs.setOperationStatCd("010");
						if ((localObject3 != null) && (((String) localObject3).equals("DocumentTitle"))) {
							localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter " + (String) localObject3
									+ "/" + str2 + " Key/Value can't be null ");
						} else {
							localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter " + (String) localObject3
									+ "/" + str2 + " Key/Value can't be null or empty ");
						}
						return localInsertDocRs;
					}
				}
				if (i == 0) {
					localArrayList1.add("DocumentTitle");
					localArrayList2.add(fName);
				}
				String str1 = decode(paramInsertDocRq.getDuplicate());
				if ((str1 != null) && ((str1.equalsIgnoreCase("True")) || (str1.equalsIgnoreCase("False")))) {
					localObject1.setUniquenessConstraint(Boolean.valueOf(str1).booleanValue());
				} else {
					localInsertDocRs.setOperationStatCd("010");
					localInsertDocRs
							.setErrStatDesc("PARAMETER_ERROR_CE Duplicate value only let the values True/False ");
					return localInsertDocRs;
				}

				com.filenet.api.core.Document localObject2 = localObject1.createDocumentAndContent(
						decode(paramInsertDocRq.getPath()), docClass,
						(String[]) localArrayList1.toArray(new String[localArrayList1.size()]),
						localArrayList2.toArray(), fName);
				Security[] localObject3 = paramInsertDocRq.getSecurityGrp();
				if (localObject3 != null) {
					for (int k = 0; k < localObject3.length; k++) {
						if (localObject3[k] == null) {
							localInsertDocRs.setOperationStatCd("010");
							localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Security Tag must have parameters");
							return localInsertDocRs;
						}
						Object localObject4 = localObject3[k];
						String str3 = decode(((Security) localObject4).getSecurityPrincipal());
						String str4 = decode(((Security) localObject4).getSecurityAccessType());
						String str5 = decode(((Security) localObject4).getSecurityAccess());
						str5 = getLevel(str5);
						String str6 = decode(((Security) localObject4).getSecurityTarget());
						if ((str3 != null) && (str3.length() > 0) && (str4 != null) && (str4.length() > 0)
								&& (str5 != null) && (str5.length() > 0) && (str6 != null) && (str6.length() > 0)) {
							this.log.debug("Adding security to Object");
							try {
								// localObject1.setPermissionsOnObject(1, ((Document) localObject2).getId(),
								// str5,
								// str4.toUpperCase(), str3, str6.toUpperCase());
								// this.log.debug("security to Object Assigned");
							} catch (Exception localException2) {
								((Document) localObject2).delete();
								if ((localException2.getMessage() != null)
										&& (localException2.getMessage().startsWith("Content Engine COM API error"))) {
									localInsertDocRs.setOperationStatCd("030");
									localInsertDocRs.setErrStatDesc(
											"ERROR_GENERAL Can't add security to object, parameter wrong.  USER="
													+ str3);
								} else {
									localInsertDocRs.setOperationStatCd("010");
									localInsertDocRs.setErrStatDesc(
											"PARAMETER_ERROR_CE Can't add security to object, parameter wrong.  ACCESSTYPE="
													+ str4 + " -ACCESS="
													+ decode(((Security) localObject4).getSecurityAccess())
													+ " -TARGET=" + str6);
								}
								this.log.debug("Error: " + localException2.getMessage());
								return localInsertDocRs;
							}
						} else {
							localInsertDocRs.setOperationStatCd("010");
							localInsertDocRs.setErrStatDesc(
									"PARAMETER_ERROR_CE Can't add security to object, parameter wrong.  USER=" + str3
											+ " -ACCESSTYPE=" + str4 + " -ACCESS="
											+ decode(((Security) localObject4).getSecurityAccess()) + " -TARGET="
											+ str6);
							this.log.debug(localInsertDocRs.getErrStatDesc());
							((Document) localObject2).delete();
							return localInsertDocRs;
						}
					}
				}
				this.log.debug("Document on CE created: " + fName);
				new java.io.File(fName).delete();
				this.log.debug("Temp Document deleted: " + fName);
				this.log.debug("ID Document created: " + localObject2.getProperties().getIdValue("Id"));				
				localInsertDocRs.setGUID(localBase64.encode(localObject2.getProperties().getIdValue("Id").toString().getBytes()));
				localInsertDocRs.setOperationStatCd("000");
			}
		} catch (Exception localException1) {
			Object localObject1 = evaluateException(localException1);
			localInsertDocRs.setOperationStatCd(((ResponseError) localObject1).getErrCd());
			localInsertDocRs.setErrStatDesc(((ResponseError) localObject1).getErrStat());
		}
		return localInsertDocRs;
	}

	private String getLevel(String paramString) {
		String str = paramString;
		if ("ViewProperties".equals(str)) {
			str = "VIEW";
		}
		if ("ViewContent".equals(str)) {
			str = "READ";
		}
		if ("ModifyProperties".equals(str)) {
			str = "WRITE_DEFAULT";
		}
		return str;
	}

	private String parseCharacters(String paramString) {
		paramString = paramString.replaceAll("\\&", "&amp;");
		paramString = paramString.replaceAll("<", "&lt;");
		paramString = paramString.replaceAll(">", "&gt;");
		return paramString;
	}

	private boolean writeFile(byte[] paramArrayOfByte, String paramString) throws Exception {
		java.io.File localFile = new java.io.File(paramString);
		localFile.createNewFile();
		FileOutputStream localFileOutputStream = new FileOutputStream(localFile, false);
		for (int i = 0; i < paramArrayOfByte.length; i++) {
			localFileOutputStream.write(paramArrayOfByte[i]);
		}
		localFileOutputStream.close();
		return true;
	}

	public final GetDocRs executeGetDocument(GetDocRq paramGetDocRq) {
		this.log.debug("Start GetContent: ");
		GetDocRs localGetDocRs = new GetDocRs();
		try {
			String str1 = decode(paramGetDocRq.getUser());
			String localObject = decode(paramGetDocRq.getPassword());
			String str2 = decode(paramGetDocRq.getObjectStore());
			String str3 = decode(paramGetDocRq.getGUID());
			if (!validateParameter(str2)) {
				localGetDocRs.setOperationStatCd("010");
				localGetDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter ObjectStore can't be empty ");
				return localGetDocRs;
			}
			if (!validateParameter(str3)) {
				localGetDocRs.setOperationStatCd("010");
				localGetDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter GUID can't be empty ");
				return localGetDocRs;
			}
			if ((str3 != null) && (str3.length() != 38)) {
				localGetDocRs.setOperationStatCd("010");
				localGetDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter GUID is wrong ");
				return localGetDocRs;
			}
			if (!validateParameter(str1)) {
				localGetDocRs.setOperationStatCd("010");
				localGetDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter User can't be empty ");
				return localGetDocRs;
			}
			if (!validateParameter((String) localObject)) {
				localGetDocRs.setOperationStatCd("010");
				localGetDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Password can't be empty ");
				return localGetDocRs;
			}
			// localObject = this.blowfish.decode((String) localObject);
			this.log.debug(str1 + "--" + "--" + str2 + "--" + str3);
			UtilFilenetP8 localUtilFilenetP8 = new UtilFilenetP8(str1, (String) localObject, str2);

			ContentTransfer localTransportInputStream = localUtilFilenetP8.getContent(str3);
			InputStream localInputStream = localTransportInputStream.accessContentStream();

			String property = "java.io.tmpdir";

			String tempDir = System.getProperty(property);
			String fileName = tempDir + java.io.File.separator + localTransportInputStream.get_RetrievalName();
			FileOutputStream fos = new FileOutputStream(fileName);

			try {
				byte[] buffer = new byte[4096000];
				int bytesRead = 0;
				while ((bytesRead = localInputStream.read(buffer)) != -1) {
					fos.write(buffer, 0, bytesRead);
				}
				System.out.println("done!");
				fos.close();
				localInputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			byte[] fileContent = Files.readAllBytes(new java.io.File(fileName).toPath());
			localTransportInputStream.accessContentStream().close();
			mx.com.metlife.filenet.cews.WSDLFile.File localFile = new mx.com.metlife.filenet.cews.WSDLFile.File();
			localFile.setContent(fileContent);
			localFile.setFilenm(localTransportInputStream.get_RetrievalName().getBytes());
			localFile.setMimeType(localTransportInputStream.get_ContentType().getBytes());
			localGetDocRs.setFile(localFile);
			localGetDocRs.setOperationStatCd("000");
			// System.out.println(arrayOfByte);
		} catch (Exception localException) {
			Object localObject = evaluateException(localException);
			localGetDocRs.setOperationStatCd(((ResponseError) localObject).getErrCd());
			localGetDocRs.setErrStatDesc(((ResponseError) localObject).getErrStat());
		}
		return localGetDocRs;
	}

	public UpdateMetadataRs executeUpdate(UpdateMetadataRq paramSearchDocRq) {
		this.log.debug("Start query");
		UpdateMetadataRs localSearchDocRs = new UpdateMetadataRs();
		UpdateMetadataRsType metadataRsType = new UpdateMetadataRsType();
		try {
			this.log.debug("Validate User");
			// String str1 = decode(paramSearchDocRq.getParameters().getUser());
			String str1 = (paramSearchDocRq.getParameters().getUser());
			if (!validateParameter(str1)) {
				metadataRsType.setOperationStatCd("010");
				metadataRsType.setErrStatDesc("PARAMETER_ERROR_CE Parameter User can't be empty ");
				localSearchDocRs.setParameters(metadataRsType);
				return localSearchDocRs;
			}
			this.log.debug("Validate Password");
			// String localObject1 = decode(paramSearchDocRq.getPassword());
			String localObject1 = (paramSearchDocRq.getParameters().getPassword());
			if (!validateParameter((String) localObject1)) {
				metadataRsType.setOperationStatCd("010");
				metadataRsType.setErrStatDesc("PARAMETER_ERROR_CE Parameter Password can't be empty ");
				localSearchDocRs.setParameters(metadataRsType);
				return localSearchDocRs;
			}
			// localObject1 = this.blowfish.decode((String) localObject1);
			this.log.debug("Validate ObjectStore");
			// String str2 = decode(paramSearchDocRq.getObjectStore());
			String str2 = (paramSearchDocRq.getParameters().getObjectStore());
			if (!validateParameter(str2)) {
				metadataRsType.setOperationStatCd("010");
				metadataRsType.setErrStatDesc("PARAMETER_ERROR_CE Parameter ObjectStore can't be empty ");
				localSearchDocRs.setParameters(metadataRsType);
				return localSearchDocRs;
			}
			this.log.debug("Validate DocClass");
			// String str3 = decode(paramSearchDocRq.getDocClass());
			String str3 = (paramSearchDocRq.getParameters().getDocClass());
			if (!validateParameter(str3)) {
				metadataRsType.setOperationStatCd("010");
				metadataRsType.setErrStatDesc("PARAMETER_ERROR_CE Parameter DocClass can't be empty ");
				localSearchDocRs.setParameters(metadataRsType);
				return localSearchDocRs;
			}
			String str4 = "";
			this.log.debug("Validate Path");
			if (paramSearchDocRq.getParameters().getPath() != null) {
				// str4 = decode(paramSearchDocRq.getPath());
				localSearchDocRs.setParameters(metadataRsType);
			}
			this.log.debug("Validate QueryCondition");
			// String str5 = decode(paramSearchDocRq.getQueryCondition());
			String str5 = (paramSearchDocRq.getParameters().getQueryCondition());
			if (!validateParameter(str5)) {
				metadataRsType.setOperationStatCd("010");
				metadataRsType.setErrStatDesc("PARAMETER_ERROR_CE Parameter QueryCondition can't be empty ");
				localSearchDocRs.setParameters(metadataRsType);
				return localSearchDocRs;
			}
			if (str5.trim().length() == 0) {
				str5 = "Id = Id ";
			}
			this.log.debug("Params");
			this.log.debug(str1 + "--" + str2 + "--" + str3 + "--" + str4 + "--" + str5);
			UtilFilenetP8 localUtilFilenetP8 = new UtilFilenetP8(str1, (String) localObject1, str2);
			UtilFilenetP8.setFormatDate(ResourceBundle.getBundle("WcmApiConfig").getString("DATEFORMAT"));
			UtilFilenetP8.setPatternDate(ResourceBundle.getBundle("WcmApiConfig").getString("DATEPATTERN"));
			UtilFilenetP8.setTimeZone(ResourceBundle.getBundle("WcmApiConfig").getString("TIMEZONE"));
			localUtilFilenetP8.setMultivalueSplit(ResourceBundle.getBundle("WcmApiConfig").getString("SPLITCHARACTER"));
			HashMap localHashMap1 = localUtilFilenetP8.getPropertyDefinitionsByClass(str3);
			List localList1 = getDateProperties(localHashMap1);
			String str6 = "";
			if ((str4 != null) && (str4.trim().length() > 0)) {
				str6 = "  " + str3 + ".This INFOLDER '" + str4 + "' AND ";
			}
			String str7 = "SELECT Id FROM ";
			str7 = str7 + str3 + " WHERE " + "VersionStatus" + "= 1 " + " AND " + str6 + parseCharacters(str5);
			String where = "VersionStatus" + "= 1 " + " AND " + str6 + parseCharacters(str5);
			this.log.debug("Query : " + str7);
			List localList2 = localUtilFilenetP8.query("Id,DocumentTitle", str3, where);//
			this.log.debug("Results : ".concat(String.valueOf(localList2.size())));
			String[] arrayOfString = fixParams(localHashMap1).split(",");
			Metadata[][] arrayOfMetadata = new Metadata[localList2.size()][];
			int i = localList2.size();
			for (int j = 0; j < i; j++) {
				this.log.debug("Start update : ".concat(String.valueOf(localList2.size())));
				HashMap localHashMap2 = (HashMap) localList2.get(j);
				localUtilFilenetP8.updatePropertiesValues(localHashMap2.get("Id").toString(),
						paramSearchDocRq.getParameters().getPropertiesStr());

			}
			metadataRsType.setErrStatDesc("");
			metadataRsType.setOperationStatCd("000");

			if (localList2.size() == 0) {
				metadataRsType.setErrStatDesc("CONTENTENGINE_FILE_NOT_FOUND The query did not match any documents.");
				metadataRsType.setOperationStatCd("005");
			}
		} catch (Exception localException1) {
			Object localObject1 = evaluateException(localException1);
			metadataRsType.setOperationStatCd(((ResponseError) localObject1).getErrCd());
			metadataRsType.setErrStatDesc(((ResponseError) localObject1).getErrStat());
		}
		localSearchDocRs.setParameters(metadataRsType);

		return localSearchDocRs;
	}

	public InsertDocRs executeInsertValida(InsertDocValidaRq paramInsertDocRq) {
		this.log.debug("Start insert: ");
		InsertDocRs localInsertDocRs = new InsertDocRs();
		try {
			ResourceBundle localResourceBundle = ResourceBundle.getBundle("WcmApiConfig");
			this.log.debug("Validate USERCONTENT");
			if (!validateParameter(localResourceBundle.getString("USERCONTENT"))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter User can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate PASSWORDCONTENT");
			// if
			// (!validateParameter(this.blowfish.decode(localResourceBundle.getString("PASSWORDCONTENT"))))
			// {
			if (!validateParameter((localResourceBundle.getString("PASSWORDCONTENT")))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Password can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate ObjectStore");
			if (!validateParameter(decode(paramInsertDocRq.getObjectStore()))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter ObjectStore can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Duplicate");
			if (!validateParameter(decode(paramInsertDocRq.getDuplicate()))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Duplicate can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Path");
			if (!validateParameter(decode(paramInsertDocRq.getPath()))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Path can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate DocClass");
			String docClass = decode(paramInsertDocRq.getDocClass());
			if (!validateParameter(docClass)) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter DocClass can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Content");
			if (!validateParameter(decode(paramInsertDocRq.getContent()))) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Content can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Filenm");
			String fName = decode(paramInsertDocRq.getFilenm());
			String tmpdir = System.getProperty("java.io.tmpdir");
			fName = tmpdir + java.io.File.separator + fName;
			if (!validateParameter(fName)) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Filenm can't be empty ");
				return localInsertDocRs;
			}
			this.log.debug("Validate Properties");
			if ((paramInsertDocRq.getProperties() == null) || (paramInsertDocRq.getProperties().length == 0)) {
				localInsertDocRs.setOperationStatCd("010");
				localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter Properties can't be null or empty ");
				return localInsertDocRs;
			}
			Base64 localBase64 = new Base64();
			UtilFilenetP8 localObject1 = new UtilFilenetP8(localResourceBundle.getString("USERCONTENT"),
					// this.blowfish.decode(localResourceBundle.getString("PASSWORDCONTENT")),
					decode(localBase64.decode(localResourceBundle.getString("PASSWORDCONTENT").getBytes())),
					decode(paramInsertDocRq.getObjectStore()));
			UtilFilenetP8.setFormatDate(ResourceBundle.getBundle("WcmApiConfig").getString("DATEFORMAT"));
			UtilFilenetP8.setPatternDate(ResourceBundle.getBundle("WcmApiConfig").getString("DATEPATTERN"));
			UtilFilenetP8.setTimeZone(ResourceBundle.getBundle("WcmApiConfig").getString("TIMEZONE"));
			localObject1.setMultivalueSplit(ResourceBundle.getBundle("WcmApiConfig").getString("SPLITCHARACTER"));
			byte[] arrayOfByte = paramInsertDocRq.getContent();
			if (writeFile(arrayOfByte, fName)) {
				this.log.debug("Temp Document created: " + fName);
				MetaDataList localMetaDataList = new MetaDataList();
				ArrayList localArrayList1 = new ArrayList();
				ArrayList localArrayList2 = new ArrayList();
				int i = 0;
				for (int j = 0; j < paramInsertDocRq.getProperties().length; j++) {
					MetadataValida localObject2 = paramInsertDocRq.getProperties()[j];
					if (localObject2 == null) {
						localInsertDocRs.setOperationStatCd("010");
						localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Metadata Tag must have parameters");
						return localInsertDocRs;
					}
					String localObject3 = decode(((MetadataValida) localObject2).getKey());
					String str2 = decode(((MetadataValida) localObject2).getValue());
					String str6 = decode(((MetadataValida) localObject2).getRequired());

					localMetaDataList.add(
							new MetaData((String) localObject3, (String) str2, Boolean.valueOf(str6).booleanValue()));

					if ((str2 != null) && (localObject3 != null) && (((String) localObject3).length() > 0)
							&& (fName != null)) {
						if ((str2 != null) && (str2.length() == 0)
								&& (((String) localObject3).equals("DocumentTitle"))) {
							str2 = fName;
						}
						localArrayList1.add(localObject3);
						localArrayList2.add(str2);
						if (((String) localObject3).equals("DocumentTitle")) {
							i = 1;
						}
					} else {
						localInsertDocRs.setOperationStatCd("010");
						if ((localObject3 != null) && (((String) localObject3).equals("DocumentTitle"))) {
							localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter " + (String) localObject3
									+ "/" + str2 + " Key/Value can't be null ");
						} else {
							localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Parameter " + (String) localObject3
									+ "/" + str2 + " Key/Value can't be null or empty ");
						}
						return localInsertDocRs;
					}
				}
				if (i == 0) {
					localArrayList1.add("DocumentTitle");
					localArrayList2.add(fName);
					localMetaDataList.add(new MetaData("DocumentTitle", fName, false));
				}
				String str1 = decode(paramInsertDocRq.getDuplicate());
				if ((str1 != null) && ((str1.equalsIgnoreCase("True")) || (str1.equalsIgnoreCase("False")))) {
					localObject1.setUniquenessConstraint(Boolean.valueOf(str1).booleanValue());
				} else {
					localInsertDocRs.setOperationStatCd("010");
					localInsertDocRs
							.setErrStatDesc("PARAMETER_ERROR_CE Duplicate value only let the values True/False ");
					return localInsertDocRs;
				}

				if (getDocumentExists(str1, docClass, localMetaDataList, localObject1)) {
					localInsertDocRs.setOperationStatCd("040");
					localInsertDocRs.setErrStatDesc(
							"ERROR_METADATA_EXISTS Document failed meta-data validations. Duplicate properties: "
									+ this.validation_msg);
					return localInsertDocRs;
				}

				com.filenet.api.core.Document localObject2 = localObject1.createDocumentAndContent(
						decode(paramInsertDocRq.getPath()), docClass,
						(String[]) localArrayList1.toArray(new String[localArrayList1.size()]),
						localArrayList2.toArray(), fName);
				Security[] localObject3 = paramInsertDocRq.getSecurityGrp();
				if (localObject3 != null) {
					for (int k = 0; k < localObject3.length; k++) {
						if (localObject3[k] == null) {
							localInsertDocRs.setOperationStatCd("010");
							localInsertDocRs.setErrStatDesc("PARAMETER_ERROR_CE Security Tag must have parameters");
							return localInsertDocRs;
						}
						Object localObject4 = localObject3[k];
						String str3 = decode(((Security) localObject4).getSecurityPrincipal());
						String str4 = decode(((Security) localObject4).getSecurityAccessType());
						String str5 = decode(((Security) localObject4).getSecurityAccess());
						str5 = getLevel(str5);
						String str6 = decode(((Security) localObject4).getSecurityTarget());
						if ((str3 != null) && (str3.length() > 0) && (str4 != null) && (str4.length() > 0)
								&& (str5 != null) && (str5.length() > 0) && (str6 != null) && (str6.length() > 0)) {
							this.log.debug("Adding security to Object");
							try {
								// localObject1.setPermissionsOnObject(1, ((Document) localObject2).getId(),
								// str5,
								// str4.toUpperCase(), str3, str6.toUpperCase());
								// this.log.debug("security to Object Assigned");
							} catch (Exception localException2) {
								((Document) localObject2).delete();
								if ((localException2.getMessage() != null)
										&& (localException2.getMessage().startsWith("Content Engine COM API error"))) {
									localInsertDocRs.setOperationStatCd("030");
									localInsertDocRs.setErrStatDesc(
											"ERROR_GENERAL Can't add security to object, parameter wrong.  USER="
													+ str3);
								} else {
									localInsertDocRs.setOperationStatCd("010");
									localInsertDocRs.setErrStatDesc(
											"PARAMETER_ERROR_CE Can't add security to object, parameter wrong.  ACCESSTYPE="
													+ str4 + " -ACCESS="
													+ decode(((Security) localObject4).getSecurityAccess())
													+ " -TARGET=" + str6);
								}
								this.log.debug("Error: " + localException2.getMessage());
								return localInsertDocRs;
							}
						} else {
							localInsertDocRs.setOperationStatCd("010");
							localInsertDocRs.setErrStatDesc(
									"PARAMETER_ERROR_CE Can't add security to object, parameter wrong.  USER=" + str3
											+ " -ACCESSTYPE=" + str4 + " -ACCESS="
											+ decode(((Security) localObject4).getSecurityAccess()) + " -TARGET="
											+ str6);
							this.log.debug(localInsertDocRs.getErrStatDesc());
							((Document) localObject2).delete();
							return localInsertDocRs;
						}
					}
				}
				this.log.debug("Document on CE created: " + fName);
				new java.io.File(fName).delete();
				this.log.debug("Temp Document deleted: " + fName);
				this.log.debug("ID Document created: " + localObject2.getProperties().getIdValue("Id"));
				localInsertDocRs.setGUID(localObject2.getProperties().getIdValue("Id").getBytes());
				localInsertDocRs.setOperationStatCd("000");
			}
		} catch (Exception localException1) {
			Object localObject1 = evaluateException(localException1);
			localInsertDocRs.setOperationStatCd(((ResponseError) localObject1).getErrCd());
			localInsertDocRs.setErrStatDesc(((ResponseError) localObject1).getErrStat());
		}
		return localInsertDocRs;
	}

	private boolean validateParameter(String paramString) {
		return (paramString != null) && (paramString.length() > 0);
	}

	private ResponseError evaluateException(Object paramObject) {
		ResponseError localResponseError = new ResponseError();
		if (paramObject == null) {
			localResponseError.setErrCd("030");
			localResponseError.setErrStat("ERROR_GENERAL Null ");
		} else if (((Exception) paramObject).getMessage() == null) {
			localResponseError.setErrCd("030");
			localResponseError.setErrStat("ERROR_GENERAL Null ");
		} else if ((paramObject instanceof InvalidContentEngineClassException)) {
			localResponseError.setErrCd("030");
			localResponseError.setErrStat("ERROR_GENERAL " + ((Exception) paramObject).getMessage());
		} else if ((paramObject instanceof ReadOnlyObjectException)) {
			localResponseError.setErrCd("030");
			localResponseError.setErrStat("ERROR_GENERAL " + ((Exception) paramObject).getMessage());
		} else if ((paramObject instanceof InvalidCredentialsException)) {
			localResponseError.setErrCd("020");
			localResponseError.setErrStat("INVALID_CREDENTIALS " + ((Exception) paramObject).getMessage());
		} else if ((paramObject instanceof RemoteServerException)) {
			if (((Exception) paramObject).getMessage().startsWith("ContentRetrieval")) {
				localResponseError.setErrCd("005");
				localResponseError.setErrStat("CONTENTENGINE_FILE_NOT_FOUND The query did not match any documents.");
			} else if ((((Exception) paramObject).getMessage().startsWith("Missing or invalid Property"))
					|| (((Exception) paramObject).getMessage().startsWith("Create failed"))) {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat("ERROR_GENERAL " + ((Exception) paramObject).getMessage());
			} else {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat("ERROR_GENERAL_CE " + ((Exception) paramObject).getMessage());
			}
		} else if ((paramObject instanceof BadReferenceException)) {
			if (((Exception) paramObject).getMessage().startsWith("ContentRetrieval: ObjectStore not found")) {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat("ERROR_GENERAL_CE " + ((Exception) paramObject).getMessage());
			} else if (((Exception) paramObject).getMessage().startsWith("ContentRetrieval")) {
				localResponseError.setErrCd("005");
				localResponseError.setErrStat("CONTENTENGINE_FILE_NOT_FOUND The query did not match any documents.");
			} else {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat("ERROR_GENERAL_CE " + ((Exception) paramObject).getMessage());
			}
		} else if ((paramObject instanceof UniquenessConstraintException)) {
			localResponseError.setErrCd("030");
			localResponseError.setErrStat("UNIQUENESSCONSTRAINT " + ((Exception) paramObject).getMessage());
		} else if ((paramObject instanceof BaseRuntimeException)) {
			localResponseError.setErrCd("020");
			localResponseError.setErrStat("ERROR_CONNECTION " + ((Exception) paramObject).getMessage());
		} else if ((paramObject instanceof Exception)) {
			if (((Exception) paramObject).getMessage().startsWith("PARAMETER_EXCEPTION")) {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat(((Exception) paramObject).getMessage());
			} else {
				localResponseError.setErrCd("030");
				localResponseError.setErrStat("ERROR_GENERAL " + ((Exception) paramObject).getMessage());
			}
		}
		return localResponseError;
	}

	private boolean getDocumentExists(String paramString1, String paramString2, MetaDataList paramMetaDataList,
			UtilFilenetP8 paramUtilFilenetP8) throws Exception {
		this.log.debug("Initializing properties validations...");
		if (paramMetaDataList.isAnyRequred()) {
			boolean bool = false;
			Iterator<com.filenet.api.core.Document> it = paramUtilFilenetP8.getDocumentsInFolder(paramString1);
			int i = 0;
			while (it.hasNext()) {
				this.log.debug("Checking document #" + i);
				i++;
				com.filenet.api.core.Document localDocument = (com.filenet.api.core.Document) it.next();
				localDocument.refresh();
				localDocument.get_Id();
				this.log.debug("Checking required properties for document #" + i);
				for (int j = 0; j < paramMetaDataList.size(); j++) {
					MetaData localMetaData = (MetaData) paramMetaDataList.get(j);
					if (localMetaData.isRequired()) {
						try {
							if (localMetaData.getValue().indexOf(';') > -1) {
								String[] values = localMetaData.getValue().split(";");
								for (int k = 0; k < values.length; k++) {
									String string = values[k];
									if (localDocument.getProperties().getStringListValue(localMetaData.getKey())
											.contains(string)) {
										bool = true;
										this.validation_msg = (this.validation_msg + " [" + localMetaData.getKey()
												+ "]");
									} else {
										bool = false;
										this.validation_msg = "";
										break;
									}
								}
							} else if (localMetaData.getValue().toString().equals(
									localDocument.getProperties().getStringValue(localMetaData.getKey()).toString())) {
								bool = true;
								this.validation_msg = (this.validation_msg + " [" + localMetaData.getKey() + "]");
							} else {
								bool = false;
								this.validation_msg = "";
								break;
							}
						} catch (Exception localException) {
							bool = false;
							this.validation_msg = "";
							break;
						}
					}
				}
				if (bool) {
					return bool;
				}
			}
		}
		this.log.debug("No need to check for properties because all input properties are Required=False");
		return false;
	}
}
