package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtilities {
	/**
	 * this method is used to fetch the value from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String getPropertyKeyValue(String key) throws IOException {
	FileInputStream fis=new FileInputStream(IPathConstants.propertyFilePath);
	Properties properties=new Properties();
	properties.load(fis);
	String value = properties.getProperty(key);
	return value;
}
}
