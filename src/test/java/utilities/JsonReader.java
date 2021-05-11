package utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

public class JsonReader {

	public static File getFile(String fileName){
		File file=new File("inputdata"+File.separator+fileName+".json");
		return file;
	}
	
	public static String readJson(String filepathwithName,String requiredValue) 

	{
		String reqKeyValue=null;
		try
		{		
			JSONParser jsonparser=new JSONParser();
			File file=new File("inputdata"+File.separator+filepathwithName+".json");
			Object object=jsonparser.parse(new FileReader(file));    
			JSONObject obj=(JSONObject)object;
			reqKeyValue = (String) obj.get(requiredValue);
			if(reqKeyValue==null)
			{
				throw new Exception();
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return reqKeyValue;
	}

	public static String getArrayData(String filepathwithName,String requiredArrayValue,int elementIndex)
	{
		String values[]=new String[20];

		try {
			JSONParser jsonparser=new JSONParser();
			File file=new File("inputdata"+File.separator+filepathwithName+".json");
			Object object=jsonparser.parse(new FileReader(file));
			JSONObject obj=(JSONObject)object;
			JSONArray msg = (JSONArray) obj.get(requiredArrayValue);
			@SuppressWarnings("unchecked")
			Iterator<String> iterator=msg.iterator();
			int count=0;
			while(iterator.hasNext())
			{
				//System.out.println(iterator.next());
				values[count]=iterator.next();
				count++;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return values[elementIndex-1];   
	}

	public static Object[] getArrayData(String filepathwithName,String requiredValue)
	{
		Object values[]=null;

		try {
			JSONParser jsonparser=new JSONParser();
			File file=new File("inputdata"+File.separator+filepathwithName+".json");
			Object object=jsonparser.parse(new FileReader(file));
			JSONObject obj=(JSONObject)object;
			JSONArray msg = (JSONArray) obj.get(requiredValue);
			values= msg.toArray();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return values;   
	}


	public static void writeTo_JsonFile(JSONObject obj,String filepath,String fileName) throws Exception
	{
		FileWriter file = new FileWriter("inputdata"+File.separator+filepath+File.separator+fileName+".json");
		try{
			file.write(obj.toJSONString());
			System.out.println("Successfully data inserted to Json File...");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			file.flush();
			file.close();
		}
	
	}
	
}
