package learn.example.dayout;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import learn.example.dayout.vo.InitZoneConfigurationVO;

public class DayoutAppMain {
	
	public static void main(String[] args) {
		DayoutAppMain app = new DayoutAppMain();
		List<InitZoneConfigurationVO> inputList = app.getInputData();
		app.getRankAppearancePossibility(inputList);
	}
	
	public List<String> getRankAppearancePossibility(List<InitZoneConfigurationVO> inputList) {
		if(null == inputList || inputList.isEmpty()) {
			return null;
		}
		List<String> resultList = inputList.stream()
				.map(vo -> determineRankAppearance(vo.getNumZoneTeamMembersArr()))
				.collect(Collectors.toList());
		System.out.println(resultList);
		return resultList;
		
	}

	private List<InitZoneConfigurationVO> getInputData() {
//		First line takes g, the number of games to be played.
//		Subsequently, g times, the following set of lines are received as input :-
//		-- First line takes n, the number of participating teams
//		-- Next, we will have 1 line for the initial configuration of each zone. In that Each line of a zone, would take n space separated integers depicting the number of members of each team present in that zone.

		int g = 3;//no. of games
		List<InitZoneConfigurationVO> list = new ArrayList<>(g);
		
		InitZoneConfigurationVO vo1 = new InitZoneConfigurationVO();
		vo1.setNumTeams(2);		
		int[][] a = {{1,1},{1,1}};
		vo1.setNumZoneTeamMembersArr(a);
		list.add(vo1);
		
		InitZoneConfigurationVO vo2 = new InitZoneConfigurationVO();
		vo2.setNumTeams(2);
		int[][] b = {{0,2},{1,1}};
		vo2.setNumZoneTeamMembersArr(b);
		list.add(vo2);
		
		InitZoneConfigurationVO vo3 = new InitZoneConfigurationVO();
		vo3.setNumTeams(3);
		int[][] c = {{2,1,2}, {1,1,1}, {2,1,1}};
		vo3.setNumZoneTeamMembersArr(c);
		list.add(vo3);
		
		return list;
	}
	

	private String determineRankAppearance(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			assert arr.length == arr[i].length;//no. of zones & no. of teams
			for(int j = 0; j < arr[i].length; j++) {
				if(i < j && arr[i][j] != arr[j][i]) {
					return "IMPOSSIBLE";
				}
			}
		}
		return "POSSIBLE";
	}

}
