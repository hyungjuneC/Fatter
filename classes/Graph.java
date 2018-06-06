package fattar;

import GraphLibrary;

public class Graph {

	public void showUserWeeklyTotalNutrient(DBmodule myDbModule){
		DrawWeeklyGraph(myDbModule.getUserInfo());  
		//import한 Graph Library와 DBmodule에서 가져온 정보를 통해 주간 그래프를 출력 시켜줌.
	}

	public void showUserPractice(DBmodule myDbModule){
		DrawCalorieGraph(myDbModule.getUserInfo());
		//import한 Graph Library와 DBmodule에서 가져온 정보를 통해 사용자가 소모한 칼로리를 그래프로 시각화 시켜줌.
	}
}