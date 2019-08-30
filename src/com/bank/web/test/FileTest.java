package com.bank.web.test;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import javax.swing.JOptionPane;

public class FileTest {
	public static final String FILE_PATH= String.format("C:%sUsers%suser%seclipse-jee%sjee-bitcamp%sWebContent%sresources%stxt%s",File.separator
			,File.separator
			,File.separator
			,File.separator
			,File.separator
			,File.separator
			,File.separator
			,File.separator);
	// "C:\\Users\\user\\eclipse-jee\\jee-bitcamp\\WebContent\\resources\\txt\\"; 이건 윈도우 운영체제에서만.. 서버는 리눅스 사용 이대로 쓰면 안됨
	public static void main(String[] args) {
		System.out.println(">>>"+FILE_PATH);
		
			try{
				File file = new File(FILE_PATH+"customers.txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
				BufferedReader reader = new BufferedReader(new FileReader(file));
				StringBuffer buff = null;
				while(true) {
				switch(JOptionPane.showInputDialog("0.종료 1.저장 2.읽기")) {
				case "0":  
					JOptionPane.showMessageDialog(null, "종료");
					return;
				case "1":
					String msg=JOptionPane.showInputDialog("메세지를 입력하세요.데이터 사이에 ,입력");
					writer.write(msg);
					writer.newLine();
					writer.flush();
					break;
				case "2":
					msg = "";
					buff = new StringBuffer();
					while((msg = reader.readLine())!= null) {
						buff.append(reader.readLine()+"/n");
					}
					JOptionPane.showMessageDialog(null, buff);
					reader.close();
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace(); //오류 나는거 추적해서 프린트해라....
		}
		
	}

}
