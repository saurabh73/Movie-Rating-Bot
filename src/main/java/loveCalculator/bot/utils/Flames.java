package loveCalculator.bot.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import loveCalculator.bot.impl.BotMessages;

public class Flames {

	public static String getResult(String firstName, String secondName) {
		
		StringBuilder response = new StringBuilder("");
		
		StringBuffer fName = new StringBuffer(firstName);
		StringBuffer sName = new StringBuffer(secondName);
		int a=fName.length();
		int b=sName.length();
		//comparing two names
		
		for(int i=0;i<a;i++){
			char c=fName.charAt(i);
			for(int j=0;j<b;j++){
				char d=sName.charAt(j);
				if(c==d){;
					fName.deleteCharAt(i);
					sName.deleteCharAt(j);
					a=fName.length();
					b=sName.length();
					i=0;
					j=0;
				}
			}
		}
		int d=(a+b)-2;
		response.append("Flames Score: "+d);

		StringBuffer flames=new StringBuffer("flames");
		
		String s4=new String();
		for(int i=0;i<5;i++){
			int n=-1,l=0,p=0;
			for(int j=1;j<=d;j++){
				n++;
				l++;
				if(n>flames.length()-1){
					char e=flames.charAt(p);
					if(l==d){
						flames.deleteCharAt(p);
						s4=flames.substring(p,flames.length());
						flames.delete(p,flames.length());
						flames.insert(0,s4);
						break;
					}else{
						p++;
						if(p==flames.length()){
							p=0;
						}
					}
				}
				else{
					if(l==d){
						flames.deleteCharAt(n);
						s4=flames.substring(n,flames.length());;
						flames.delete(n,flames.length());
						flames.insert(0,s4);
						break;
					}
				}
			}
		}
		response.append("\n");
		char result=flames.charAt(0);
		switch(result){
			case 'f':	response.append(firstName+" is friends with "+secondName);
						break;
			case 'l':	response.append(secondName+" is love of "+firstName);
						break;
			case 'a':   response.append(firstName+" feels affectionate towards "+secondName);
						break;
			case 'm':	response.append(firstName+" will marry "+secondName);
						break;
			case 'e':	response.append(secondName+" is enemy of "+firstName);
						break;
			case 's':	System.out.println(firstName+" and " +secondName +"are siblings");
						break;
		}
		
		String apiResulresult = BotMessages.DEFAULT_ERROR;
		try {
			apiResulresult = URLEncoder.encode(response.toString(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return apiResulresult;
		
	}

}
