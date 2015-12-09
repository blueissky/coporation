package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFile {
	private InputStream is;
	private Properties property;

	public PropertyFile() {
		this("config.properties");
	}

	public PropertyFile(String propertyFileName) {
		this.is = PropertyFile.class.getClassLoader().getResourceAsStream(propertyFileName);
		this.property = new Properties();
		try {
			this.property.load(this.is);
		} catch (IOException e) {
			e.printStackTrace();
			try {
				this.is.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				this.is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String read(String key) {
		return this.property.getProperty(key);
	}

	public void write(String key, String value) {
		this.property.setProperty(key, value);
	}
}