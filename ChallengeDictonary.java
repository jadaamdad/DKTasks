package ethos.model.content.dailytasks;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.collect.Range;
public class ChallengeDictonary {
	static enum CHALLENGE_TYPES{
		PVM,
		SKILLING
	}
	static enum CHALLENGE_MODE{
		EASY,
		MEDIUM,
		HARD
	}
	//a template defining how each Challenge Type class should look
	private static abstract class ChallengeTypeTemplate{
		Range<Integer> easyRange;
		Range<Integer> mediumRange;
		Range<Integer> hardRange;
		public  ChallengeTypeTemplate(Range<Integer> easyRange,Range<Integer> mediumRange,
			    Range<Integer> hardRange){
			this.easyRange = easyRange;
			this.mediumRange = mediumRange;
			this.hardRange = hardRange;
		}
	}
	 public static class PVM extends ChallengeTypeTemplate{
		 // a hashmap with each mode and the monster ids associated
		private HashMap<CHALLENGE_MODE,ArrayList<Integer>> monsterChallenges = new HashMap<>();
		public PVM(Range<Integer> easyRange, Range<Integer> mediumRange, Range<Integer> hardRange) {
			super(easyRange, mediumRange, hardRange);
			monsterChallenges.put(CHALLENGE_MODE.EASY, new ArrayList<>());
			monsterChallenges.put(CHALLENGE_MODE.MEDIUM, new ArrayList<>());
			monsterChallenges.put(CHALLENGE_MODE.HARD, new ArrayList<>());
		}
		public  void addAllIds(CHALLENGE_MODE m, ArrayList<Integer> ids) {
			monsterChallenges.get(m).addAll(ids);
		}
		public void test() {
			System.out.println("-----------------PVM Template test--------------");
			System.out.println(easyRange);
			System.out.println(mediumRange);
			System.out.println(hardRange);
			//System.out.println(monsterChallenges);
			System.out.println("-----------------PVM Template end--------------");
		}
	}
	 public static void readChallengeJSON() {
		 JSONParser parser = new JSONParser();
			try(Reader reader = new FileReader("C:/Users/jadaa/Desktop/PVM_Challenges.json")){
				JSONObject jsonObject = (JSONObject) parser.parse(reader);

				JSONArray challengeRanges = (JSONArray) jsonObject.get("challengeRanges");
	            Iterator<Integer> it = challengeRanges.iterator();
	            JSONObject easyRangeObj = (JSONObject) challengeRanges.get(0);
	            JSONObject mediumRangeObj = (JSONObject) challengeRanges.get(1);
	            JSONObject hardRangeObj = (JSONObject) challengeRanges.get(2);
	            Range<Integer> easyRange = Range.closed(new Integer(((Long) easyRangeObj.get("easyChallengeMin")).intValue()), 
	            		new Integer(((Long) easyRangeObj.get("easyChallengeMax")).intValue()));
	            Range<Integer> mediumRange = Range.closed(new Integer(((Long) mediumRangeObj.get("mediumChallengeMin")).intValue()), 
	            		new Integer(((Long) mediumRangeObj.get("mediumChallengeMax")).intValue()));
	            Range<Integer> hardRange = Range.closed(new Integer(((Long) hardRangeObj.get("hardChallengeMin")).intValue()), 
	            		new Integer(((Long) hardRangeObj.get("hardChallengeMax")).intValue()));
	         new ChallengeDictonary.PVM(easyRange,mediumRange,hardRange).test();
	         
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
}
