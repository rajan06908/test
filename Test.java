import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {

	public static void main(String[] args) throws ParseException, InterruptedException, ExecutionException, IOException {
//		double double1 = 10.0d;
//		Instant instant = Instant.now();
//		// get overall time
//		LocalTime time = instant.atZone(ZoneOffset.UTC).toLocalTime();
//		// get hour
//		int hour = instant.atZone(ZoneOffset.UTC).getHour();
//		// get minute
//		int minute = instant.atZone(ZoneOffset.UTC).getMinute();
//		// get second
//		int second = instant.atZone(ZoneOffset.UTC).getSecond();
//		// get nano
//		int nano = instant.atZone(ZoneOffset.UTC).getNano();
//		instant = instant.atZone(ZoneOffset.UTC)
//		        .withHour(hour-3)
//		        .toInstant();
//		System.out.println(instant.toEpochMilli());

//		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	        Date date1 = sdf.parse("2009-12-31");
//	        Date date2 = sdf.parse("2010-01-31");
//	        System.out.println(date1.after(date2));
//	        
//	        Calendar rightNow = Calendar.getInstance(TimeZone.getTimeZone("PST"));
//		    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH:mm:ss", Locale.ENGLISH);  
//		    formatter.setTimeZone(TimeZone.getTimeZone("PST"));
//		    String currentDateTimeStamp = formatter.format(rightNow.getTime());  
//		    rightNow.add(Calendar.HOUR, -1);
//		    String prevDateTimeStamp = formatter.format(rightNow.getTime()); 
//		   // System.out.println(currentDateTimeStamp +" "+ prevDateTimeStamp);
//		    //85078900204|6501|749972|734|0|0|0|648|Y|1561110639000|1561110906301|D|P||U
//		    //912848045|4861|970506|289|0|0|0|0|Y|1561110615000|1561110906357|D|P||U
//		    Date date = new Date(1562176059000l);
//		    System.out.println(date);
//		    
//		    
//		    List<String> cities = Arrays.asList("Milan", 
//                    "London", 
//                    "New York", 
//                    "San Francisco");
//String citiesCommaSeparated = String.join("','", cities);
//System.out.println(citiesCommaSeparated);

		ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(4);

//		ExecutorService executorService = new ThreadPoolExecutor(4, 4, 10000, TimeUnit.SECONDS, queue);
//		CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
//		completionService.submit(new Task(concurrentHashMap, 0, 50000));
//		completionService.submit(new Task(concurrentHashMap, 50000,100000));
//		for (int i = 0; i < 2; i++) {
//			System.out.println("result: "+completionService.take().get());
//		}
//		ConcurrentHashMap<Integer, Integer> tempConcurrentHashMap = new ConcurrentHashMap<>();
//		tempConcurrentHashMap.putAll(concurrentHashMap);
//		System.out.println(tempConcurrentHashMap.size());
//		long t1 = System.currentTimeMillis();
//		//BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(100000);
//		//tempConcurrentHashMap.forEach((k,v)->{bq.add(k);});
//		ArrayList<Integer> sortedKeys = new ArrayList<Integer>(concurrentHashMap.keySet());
//		Collections.sort(sortedKeys);
//		System.out.println(t1 - System.currentTimeMillis());
////		m.forEach((x,y)->System.out.println(x+" "+y));
//		System.out.println(sortedKeys.size());
//		executorService.shutdown();
		
		System.out.print(new Date(1566537343));
	}
	

}

class Task implements Callable<Integer> {

	ConcurrentHashMap<Integer, Integer> concurrentHashMap;

	Integer start = 0;
	
	Integer end = 0;

	public Task(ConcurrentHashMap<Integer, Integer> concurrentHashMap, Integer start, Integer end) {
		this.concurrentHashMap = concurrentHashMap;
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Running:" +Thread.currentThread().getName());
		for (int i = start; i < end; i++) {
			concurrentHashMap.put(i, i);
		}
		return concurrentHashMap.size();
	}

}
