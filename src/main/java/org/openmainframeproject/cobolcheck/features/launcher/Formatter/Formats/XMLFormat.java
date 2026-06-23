package org.openmainframeproject.cobolcheck.features.launcher.Formatter.Formats;

import org.openmainframeproject.cobolcheck.features.launcher.Formatter.DataTransferObjects.DataTransferObjectStyle;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.File;

public class XMLFormat extends Formatter{

    public XMLFormat(DataTransferObjectStyle dataTransferObjectStyle){
        super(dataTransferObjectStyle);
    }

    @Override
    public String writeInFormat(String path) throws JAXBException {
        Object dataTransferObject = this.dataTransferObject.getDataTransferObject();
        JAXBContext context = JAXBContext.newInstance(dataTransferObject.getClass());
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(dataTransferObject, new File(path));
        return mar.toString();
    }
}
