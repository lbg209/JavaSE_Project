package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Publication;
import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {
	
	// 타입별 평균 가격 계산 메서드
	public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
		Map<String, Integer> totalPrice = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        Map<String, Double> averagePrice = new HashMap<>();

        for (Publication pub : publications) {

            String type = getPublicationType(pub);

            totalPrice.put(type, totalPrice.getOrDefault(type, 0) + pub.getPrice());

            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        // 평균 가격 계산
        for (String type : totalPrice.keySet()) {

            double average = (double) totalPrice.get(type) / count.get(type);

            averagePrice.put(type, average);
        }

        return averagePrice;
	}
	
	// 출판물 유형 분포 계산 메서드
	public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
		Map<String, Integer> count = new HashMap<>();
        Map<String, Double> distribution = new HashMap<>();

        for (Publication pub : publications) {

            String type = getPublicationType(pub);

            count.put(type, count.getOrDefault(type, 0) + 1);
        }

        // 유형별 백분율 계산
        for (String type : count.keySet()) {

            double percentage = (double) count.get(type) / publications.length * 100;

            distribution.put(type, percentage);
        }

        return distribution;
		
	}
	
	// 특정 연도 출판물 비율 계산 메서드
	public double calculatePublicationRatioByYear(Publication[] publications, String year) {
		int count = 0;

        for (Publication pub : publications) {

            String publishDate = pub.getPublishDate();

            if (publishDate.substring(0, 4).equals(year)) {
                count++;
            }
        }

        return (double) count / publications.length * 100;
		
	}
	
	// 출판물 타입 확인 헬퍼 메서드
	private String getPublicationType(Publication pub) {
		if (pub instanceof Novel) {
            return "소설";

        } else if (pub instanceof Magazine) {
            return "잡지";

        } else if (pub instanceof ReferenceBook) {
            return "참고서";

        } else {
            return "기타";
        }
		
	}

	// 통계 정보 출력 메서드
	public void printStatistics(Publication[] publications){
		DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("\n========== 출판물 통계 분석 ==========");

        // 타입별 평균 가격
        System.out.println("\n[타입별 평균 가격]");

        Map<String, Double> averagePrices = calculateAveragePriceByType(publications);

        for (String type : averagePrices.keySet()) {

            System.out.println(type + ": " + df.format(averagePrices.get(type)) + "원");
        }


        // 출판물 유형 분포
        System.out.println("\n[출판물 유형 분포]");

        Map<String, Double> distributions = calculatePublicationDistribution(publications);

        for (String type : distributions.keySet()) {

            System.out.println(type + ": " + df.format(distributions.get(type)) + "%");
        }


        // 2007년도 출판물 비율
        System.out.println("\n[2007년도 출판물 비율]");

        double ratio = calculatePublicationRatioByYear(publications, "2007");

        System.out.println("2007년 출판물 비율: " + df.format(ratio) + "%");

        System.out.println("=====================================");
    }

}
