package Assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Journey {
	private Vehicles vehicles;
	private ArrayList<Jcsv> jcsv = new ArrayList<Jcsv>(); //jcsv 어레이리스트 선언, Jcsv라는 클래스를 데이터타입으로 넣는다.
	private ArrayList<Vcsv> vcsv = new ArrayList<Vcsv>(); //이렇게 선언하면 나중에 어레이리스트에 들어가있는 자료를  getter를 이용해서 정보를 가져올 수 있다.

	
	public Journey() throws IOException{
		jcsv = getJcsv(); //1
		vcsv = getVcsv(); //2
	}
	

	public ArrayList<Jcsv> getJcsv() throws IOException, FileNotFoundException{//3
		
		// csv파일을 arraylist로 변환해서 journey에 삽입하는방
		String temp = "";
		
		
		try { // 파일을 읽어서 \n단위로 스플릿을 해서 어레이리스트 한칸한칸에 넣어다.
			File csv = new File("/Users/bomeeryu_c/Desktop/csv/Journeys.csv");
	
			// ArrayList<String> jcsvList = new ArrayList<>();
			
			BufferedReader br = new BufferedReader(new FileReader(csv));
			while ((temp = br.readLine()) != null) { // br.readline이null이 아니라면
				String[] splitTemp = temp.split(",");
				jcsv.add(new Jcsv(splitTemp[0],splitTemp[1],splitTemp[2],splitTemp[3])); //객체화된 정보를 어레이리스트에 add, 생성자 매개변수에 스플릿한 정보를 넣어준다.
			}//
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//	return new ArrayList<Jcsv> ();
		}
		
		return jcsv;
	}
	
	public ArrayList<Vcsv> getVcsv() throws IOException{ //4
		String temp = "";
		// csv파일을 arraylist로 변환해서 journey에 삽입하는 방법
	
		try { // 파일을 읽어서 \n단위로 스플릿을 해서 어레이리스트 한칸한칸에 넣어준다.
			File csv = new File("/Users/bomeeryu_c/Desktop/csv/Vehicles.csv");
	
			// ArrayList<String> jcsvList = new ArrayList<>();
			
			BufferedReader br = new BufferedReader(new FileReader(csv));
			while ((temp = br.readLine()) != null) { // br.readline이null이 아니라
				String[] splitTemp = temp.split(",");
				vcsv.add(new Vcsv(splitTemp[0],splitTemp[1],splitTemp[2]));
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vcsv;
	}
	
	public void run(){ //5
		
		String jcsvRegNum;
		String vcsvRegNum;
		int distance;
		int passengers;
		String destination;
		double price = 0;
		double totalPrice = 0.0;
		
		Taxi taxi = new Taxi(); //6
		Shuttle shuttle = new Shuttle(); //9
		
		for (int i=0 ; i <jcsv.size(); i ++){ //i는 0부터 jcs어레이리스트의 사이즈만큼 1씩 증가한다.		
			jcsvRegNum = jcsv.get(i).getRegNum(); //인덱스i에 있는 레그넘을 가져온다.
			
			for (int j = 0; j<vcsv.size() ; j++){  //vcsv의 인덱스를vcsv의 사이즈만큼 루프를 돌린다.			
				vcsvRegNum = vcsv.get(j).getRegNum();
				
				if(jcsvRegNum.equals(vcsvRegNum)){ //만약 jcsv의 레그넘과 vcsv의 레그넘이 같다				
					distance = jcsv.get(i).getKilo(); //  거리는 getkilo로 가져온다 
					passengers = jcsv.get(i).getPassengers(); // 운송객은 getPassengers로 가져온다 
					destination = jcsv.get(i).getDestination(); // 도착지는 getDestination으로 가져온다.
					
					if (vcsv.get(j).getVehiclesType().equals("TAXI")){  //vcsv리스트에 있는 j인덱스에서 운송타입을 가져와서 그 글자가 TAXI라면
						price = taxi.charge(passengers, distance); // 가격은 택시 객체에 있는 차지 메서드에 값을 넘겨 가져온다.					
					}
					else if (vcsv.get(j).getVehiclesType().equals("SHUTTLE")){ //셔틀이라면 
						price = shuttle.charge(passengers, distance); //가격은 셔틀가격 
					//	System.out.println(jcsvRegNum +" "+destination+" "+ price); //
					}
					
					System.out.println(jcsvRegNum +String.format("%50s",destination)+"\n"+String.format("%8.0f", price)+" won");
					
			}
		}
			totalPrice = totalPrice + price;
		}
		System.out.println("Total = "+String.format("%8.0f", totalPrice)+" won");

	}
}
