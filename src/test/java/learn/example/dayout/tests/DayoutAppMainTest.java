package learn.example.dayout.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import learn.example.dayout.DayoutAppMain;
import learn.example.dayout.vo.InitZoneConfigurationVO;

@TestInstance(Lifecycle.PER_CLASS)
public class DayoutAppMainTest {
	
	private DayoutAppMain app;
	
	@BeforeAll
	public void init() {
		app = new DayoutAppMain();
	}
	
	@Test
	public void testNullInput() {
		assertNull(app.getRankAppearancePossibility(null));
	}
	
	@Test
	public void testEmptyInput() {
		assertNull(app.getRankAppearancePossibility(new ArrayList<>()));
	}
	
	@Test
	public void testHappyPath() {
		List<String> list = app.getRankAppearancePossibility(sample1());
		assertNotNull(list);
		assertNotNull(list.get(0));
		assertEquals(list.get(0), "POSSIBLE");
	}
	
	@Test
	public void testForImpossible() {
		List<String> list = app.getRankAppearancePossibility(sample2());
		assertNotNull(list);
		assertNotNull(list.get(0));
		assertEquals(list.get(0), "IMPOSSIBLE");
	}	
	
	@Test
	public void testMultiInpt() {
		List<String> list = app.getRankAppearancePossibility(sample3());
		
		assertNotNull(list);
		assertEquals(list.size(), 2);
		
		assertNotNull(list.get(0));
		assertEquals(list.get(0), "IMPOSSIBLE");
		
		assertNotNull(list.get(1));
		assertEquals(list.get(1), "POSSIBLE");
	}
	
	private List<InitZoneConfigurationVO> sample3() {
		List<InitZoneConfigurationVO> list = new ArrayList<>();
		
		InitZoneConfigurationVO vo1 = new InitZoneConfigurationVO();
		vo1.setNumTeams(2);		
		int[][] a = {{0,2},{1,2}};
		vo1.setNumZoneTeamMembersArr(a);
		list.add(vo1);
		
		InitZoneConfigurationVO vo2 = new InitZoneConfigurationVO();
		vo2.setNumTeams(4);		
		int[][] b = {{1,2,3,4}, {2,5,6,7}, {3,6,8,9}, {4,7,9,0}};
		vo2.setNumZoneTeamMembersArr(b);
		list.add(vo2);
		
		return list;
	}
	
	private List<InitZoneConfigurationVO> sample2() {
		List<InitZoneConfigurationVO> list = new ArrayList<>();
		
		InitZoneConfigurationVO vo1 = new InitZoneConfigurationVO();
		vo1.setNumTeams(2);		
		int[][] a = {{0,2},{1,2}};
		vo1.setNumZoneTeamMembersArr(a);
		list.add(vo1);
		
		return list;
	}
	
	
	private List<InitZoneConfigurationVO> sample1() {
		List<InitZoneConfigurationVO> list = new ArrayList<>();
		
		InitZoneConfigurationVO vo1 = new InitZoneConfigurationVO();
		vo1.setNumTeams(4);		
		int[][] a = {{1,2,3,4}, {2,5,6,7}, {3,6,8,9}, {4,7,9,0}};
		vo1.setNumZoneTeamMembersArr(a);
		list.add(vo1);
		
		return list;
	}

}
