package util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBUtil {
	public static Object read(File xmlFile, Class<?> oclass) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(oclass);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return unmarshaller.unmarshal(xmlFile);
	}
	
	public static void save(Object object, Class<?> oclass, File xmlFile) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(oclass);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(object, xmlFile);
	}
}
