package com.programs;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException; 



public class XMLSerializerDemo {
	String str = null;
	XMLSerializerDemo() {
		setString();
		String newStr = format(str);
	}
	public String format(String str) {
		Document document = parseXML(str);
		
		OutputFormat format = new OutputFormat(document);
		format.setLineWidth(65);
		format.setIndenting(true);
		format.setIndent(2);
		Writer out = new StringWriter();
		XMLSerializer serializer = new XMLSerializer(out, format);
		try {
			serializer.serialize(document);
			return out.toString();
		}
		catch(IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	public void setString() {
		this.str = "<emp><name>amit</name></emp>";
	}
	
	public Document parseXML(String in) {
		try {
	           DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	           DocumentBuilder db = dbf.newDocumentBuilder();
	           InputSource is = new InputSource(new StringReader(in));
	           return db.parse(is);
	       } catch (ParserConfigurationException e) {
	           throw new RuntimeException(e);
	       } catch (SAXException e) {
	           throw new RuntimeException(e);
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	       return null;
	}
}
