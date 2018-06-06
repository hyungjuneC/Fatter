
public class FatterMath {
	
	public FatterMath() {
		// TODO Auto-generated constructor stub
	}
	
	// 영양소 계산
	public double totalNutrient() {
		
	}
	
	// 먹은음식 전체음식 칼로리 계산
	public evaluateEatenFood() {
		
	}
	
	// BMR(기초대사량) 계산
	public double calculBMR(User user) {
		
		User tmp = user.getinfo();
		
		// male일 경우
		if(tmp.sex == true)
			return (66 + (13.7 * tmp.weight) + (5.0 * tmp.height) - (6.8 * tmp.age));
		
		// female일 경우
		else 
			return (655 + (9.6 * tmp.weight) + (1.8 * tmp.height) - (4.7 * tmp.age));
	}
}
