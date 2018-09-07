package com.intent.admin.file;

import com.filenet.wcm.api.TransportInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.mail.MessagingException;
import javax.mail.Part;
import org.apache.log4j.Logger;

public class UtilFile {
	private int BUFFER_SIZE = 8192;
	private static Logger log = Logger.getLogger(UtilFile.class);

	public static List getFile(String url) throws FileNotFoundException {
		List files = new ArrayList();
		File f = new File(url);
		if (f.isDirectory()) {
			String[] filesNames = f.list();
			if (files != null) {
				for (int i = 0; i < filesNames.length; i++) {
					files.add(new FileInputStream(url + "/" + filesNames[i]));
				}
			}
		} else {
			files.add(new FileInputStream(f));
		}
		return files;
	}

	public static List getFilesNames(String url) throws FileNotFoundException {
		List files = new ArrayList();
		File f = new File(url);
		if (f.isDirectory()) {
			String[] filesNames = f.list();
			if (files != null) {
				for (int i = 0; i < filesNames.length; i++) {
					files.add(filesNames[i]);
				}
			}
		} else {
			files.add(url);
		}
		return files;
	}

	public static StringBuffer readFileByLines(String fileName) {
		StringBuffer l = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			try {
				l = new StringBuffer();
				String s;
				while ((s = in.readLine()) != null) {
					l.append(s + "\r\n");
				}
				in.close();
			} catch (IOException e) {
				if (!log.isDebugEnabled()) {
					return l;
				}
				log.debug(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			String s;
			if (log.isDebugEnabled()) {
				log.debug(e.getMessage());
			}
		}
		return l;
	}

	public static List readCSVFile(String fileName, String separator, boolean includeHeader) throws Exception {
		List l = new ArrayList();
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		try {
			double lines = 0.0D;
			String[] headers = new String[0];
			String s;
			while ((s = in.readLine()) != null) {
				String[] vals = s.split(separator);
				if (lines == 0.0D) {
					if (includeHeader) {
						headers = vals;
					} else {
						headers = new String[vals.length];
						for (int i = 0; i < vals.length; i++) {
							headers[i] = ("COLUMN" + i);
						}
						HashMap map = new HashMap();
						for (int i = 0; i < vals.length; i++) {
							map.put(headers[i], vals[i]);
						}
						l.add(map);
					}
				} else {
					HashMap map = new HashMap();
					if (headers.length == vals.length) {
						for (int i = 0; i < headers.length; i++) {
							map.put(headers[i], vals[i]);
						}
						l.add(map);
					} else {
						throw new Exception("ReadCVSFileException: Problem read line " + (lines + 1.0D)
								+ ", the data is not according with data.  Columns Length.");
					}
				}
				lines += 1.0D;
			}
			in.close();
		} catch (IOException e) {
			if (log.isDebugEnabled()) {
				log.debug(e.getMessage());
			}
		}
		return l;
	}

	public static boolean write(String fileName, List text, boolean append, String separator) {
		return write(fileName, text, append, separator, true);
	}

	public static boolean write(String fileName, List text, boolean append, String separator, boolean insertKeys) {
		StringBuffer buffer = new StringBuffer();

		List keys = new ArrayList();
		for (int i = 0; i < text.size(); i++) {
			HashMap map = (HashMap) text.get(i);
			Set set = map.keySet();
			for (Iterator iter = set.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				if (!keys.contains(key)) {
					keys.add(key);
				}
			}
		}
		if (insertKeys) {
			for (Iterator iter = keys.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				buffer.append(key);
				buffer.append(separator);
			}
		}
		buffer.append("\r\n");
		for (int i = 0; i < text.size(); i++) {
			HashMap map = (HashMap) text.get(i);
			for (Iterator iter = keys.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				buffer.append(map.get(key));
				buffer.append(separator);
			}
			buffer.append("\r\n");
		}
		return write(fileName, buffer, append);
	}

	public static boolean write(String fileName, Object text, boolean append) {
		try {
			if ((text instanceof String)) {
				FileWriter fw = new FileWriter(fileName, append);
				fw.write((String) text);
				fw.close();
			} else if ((text instanceof StringBuffer)) {
				FileWriter fw = new FileWriter(fileName, append);
				fw.write(text.toString());
				fw.close();
			} else if ((text instanceof TransportInputStream)) {
				File dst = new File(fileName);
				if (dst.isDirectory()) {
					dst = new File(fileName + "/" + ((TransportInputStream) text).getFilename());
				}
				OutputStream out = new FileOutputStream(dst);
				byte[] buf = new byte['?'];
				int len;
				while ((len = ((TransportInputStream) text).read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				((TransportInputStream) text).close();
				out.close();
			} else if ((text instanceof List)) {
				List files = (List) text;
				for (int i = 0; i < files.size(); i++) {
					InputStream in = new FileInputStream((File) files.get(i));
					File dst = new File(fileName);
					if (!dst.isDirectory()) {
						String[] vars = fileName.split("/");
						fileName = "";
						for (int j = 0; j < vars.length - 1; j++) {
							fileName = fileName + vars[j] + "/";
						}
					}
					OutputStream out = new FileOutputStream(fileName + ((File) files.get(i)).getName());
					byte[] buf = new byte['?'];
					int len;
					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
					}
					in.close();
					out.close();
				}
			} else if ((text instanceof File)) {
				File dst = new File(fileName);
				if (dst.isDirectory()) {
					dst = new File(fileName + "/" + ((File) text).getName());
				}
				InputStream in = new FileInputStream((File) text);
				OutputStream out = new FileOutputStream(dst);
				byte[] buf = new byte['?'];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				((TransportInputStream) text).close();
				out.close();
			} else if ((text instanceof FileInputStream)) {
				File dst = new File(fileName);
				if (dst.isDirectory()) {
					dst = new File(fileName + "/file" + Math.random());
				}
				InputStream in = (FileInputStream) text;
				OutputStream out = new FileOutputStream(dst);
				byte[] buf = new byte['?'];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();
			} else {
				try {
					File dst = new File(fileName);
					InputStream in = ((Part) text).getInputStream();
					if (dst.isDirectory()) {
						dst = new File(fileName + "/" + ((Part) text).getFileName());
					} else {
						String[] vars = fileName.split("/");
						fileName = "";
						for (int j = 0; j < vars.length - 1; j++) {
							fileName = fileName + vars[j] + "/";
						}
						dst = new File(fileName + ((Part) text).getFileName());
					}
					OutputStream out = new FileOutputStream(dst);
					byte[] buf = new byte['?'];
					int len;
					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
					}
					in.close();
					out.close();
				} catch (MessagingException e) {
					if (log.isDebugEnabled()) {
						log.debug(e.getMessage());
					}
				}
			}
			return true;
		} catch (IOException ioe) {
			if (log.isDebugEnabled()) {
				log.debug("Se ha producido un error durante la lectura del archivo " + fileName);
			}
		}
		return false;
	}

	public static int delete(String url) {
		int count = 0;
		File f = new File(url);
		if (f.isDirectory()) {
			String[] filesNames = f.list();
			for (int i = 0; i < filesNames.length; i++) {
				delete(url + "/" + filesNames[i]);
				count++;
			}
			f.delete();
		} else {
			f.delete();
			count++;
		}
		return count;
	}

	public static void replaceValuesInFile(String path, String[] valuesToSearch, String[] valuesToReplace) {
		String textComplete = readFileByLines(path).toString();
		for (int i = 0; i < valuesToSearch.length; i++) {
			textComplete = textComplete.replaceAll(valuesToSearch[i], valuesToReplace[i]);
		}
		write(path, textComplete, false);
	}

	public boolean contains(String path, String valueToSearch) {
		String textComplete = readFileByLines(path).toString();
		if (textComplete.indexOf(valueToSearch) > -1) {
			return true;
		}
		return false;
	}

	public boolean copy(String urlSource, String urlDestination) {
		File f = new File(urlSource);
		boolean copy = true;
		if (f.isDirectory()) {
			String[] filesNames = f.list();
			File dest = new File(urlDestination);
			dest.mkdirs();
			for (int i = 0; i < filesNames.length; i++) {
				copy(urlSource + File.separator + filesNames[i], urlDestination + File.separator + filesNames[i]);
			}
		} else {
			StringBuffer buffer = readFileByLines(urlSource);
			copy = write(urlDestination, buffer, false);
		}
		return copy;
	}

	public boolean move(String urlSource, String urlDestination) {
		File f = new File(urlSource);
		if (f.isDirectory()) {
			String[] filesNames = f.list();
			File dest = new File(urlDestination);
			dest.mkdirs();
			for (int i = 0; i < filesNames.length; i++) {
				move(urlSource + File.separator + filesNames[i], urlDestination + File.separator + filesNames[i]);
				delete(urlSource + File.separator + filesNames[i]);
			}
		} else {
			StringBuffer buffer = readFileByLines(urlSource);
			boolean copy = write(urlDestination, buffer, false);
			if (copy) {
				delete(urlSource);
			}
		}
		return true;
	}

	public boolean unzip(String urlZipFile, String urlDestination) {
		String destination = urlDestination;

		String fileName = urlZipFile;
		try {
			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream(fileName);
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));

			byte[] data = new byte[this.BUFFER_SIZE];
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				if (!entry.isDirectory()) {
					String entryName = entry.getName();
					prepareFileDirectories(destination, entryName);
					String destFN = destination + File.separator
							+ entry.getName().substring(entry.getName().indexOf("/"));

					FileOutputStream fos = new FileOutputStream(destFN);
					dest = new BufferedOutputStream(fos, this.BUFFER_SIZE);
					int count;
					while ((count = zis.read(data, 0, this.BUFFER_SIZE)) != -1) {
						dest.write(data, 0, count);
					}
					dest.flush();
					dest.close();
				}
			}
			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private void prepareFileDirectories(String destination, String entryName) {
		String[] values = entryName.split("/");
		for (int i = 1; i < values.length - 1; i++) {
			destination = destination + File.separator + values[i];
		}
		File dest = new File(destination);
		dest.mkdirs();
	}

	public boolean zip(String urlSource, String destination) {
		List files = new ArrayList();
		try {
			files = getFilesNames(urlSource);
		} catch (FileNotFoundException e1) {
			log.debug("Error zip file: ", e1);
		}
		String fileName = destination;
		try {
			BufferedInputStream origin = null;

			FileOutputStream dest = new FileOutputStream(fileName);

			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

			byte[] data = new byte[this.BUFFER_SIZE];
			for (Iterator i = files.iterator(); i.hasNext();) {
				String filename = (String) i.next();

				FileInputStream fi = new FileInputStream(urlSource + File.separator + filename);
				origin = new BufferedInputStream(fi, this.BUFFER_SIZE);
				ZipEntry entry = new ZipEntry(filename);
				out.putNextEntry(entry);
				int count;
				while ((count = origin.read(data, 0, this.BUFFER_SIZE)) != -1) {
					out.write(data, 0, count);
				}
				origin.close();
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
