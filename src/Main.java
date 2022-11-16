import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static List<MusicalInstruments> getAll()
    {
        List<MusicalInstruments> al = new ArrayList<>();
        al.add(new MusicalInstruments("guitar",1599.0));
        al.add(new MusicalInstruments("Trumpet",299.99));
        al.add(new MusicalInstruments("Tuba",1149.0));
        al.add(new MusicalInstruments("Timpani",239.0));
        al.add(new MusicalInstruments("Piano",5179.99));
        al.add(new MusicalInstruments("Trombone",775.79));
        return al;
    }
    public static void main(String[] args) {
        List<MusicalInstruments> musicalInstruments = Main.getAll();


        // partition according to the price
        //partitioningBy(predicate)
        Map<Boolean, List<MusicalInstruments>> partitionBy1 = musicalInstruments.stream()
                .collect(Collectors.partitioningBy(instrument -> instrument.getPrice() > 500));

        // printing the partitionBy1
        partitionBy1.forEach((key,value)->{
            System.out.println(key?"Expensive":"Affordable");
            value.forEach(System.out::println);
        });


        // if I want to perform any reducing operation then
        // partitioningBy(predicate, collector(downstream))
        Map<Boolean, Long> partitionBy2 = musicalInstruments.stream()
                .collect(Collectors.partitioningBy(instrument -> instrument.getPrice() > 500, Collectors.counting()));
        System.out.println(partitionBy2);
    }
}