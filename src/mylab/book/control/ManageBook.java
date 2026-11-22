package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		Publication[] publications = {
				new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
		        new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
		        new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
		        new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
		        new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
		        new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
		        new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
		    };
		
		
		for (int i = 0; i < publications.length; i++) {
            System.out.println((i + 1) + ". " + publications[i].toString());
        }
		
		// 3번째 도서 가격 변경
		int originalPrice = publications[2].getPrice();

        // 가격 변경
        modifyPrice(publications[2]);

        // 변경 후 가격
        int changedPrice = publications[2].getPrice();

        // 차액 계산
        int difference = originalPrice - changedPrice;
        // 결과 출력
        System.out.println("\n[가격 변경 결과]");
        System.out.println("도서명: " + publications[2]);
        System.out.println("변경 전 가격: " + originalPrice);
        System.out.println("변경 후 가격: " + changedPrice);
        System.out.println("할인 금액: " + difference);
        
        // 6. 통계 분석 실행
        System.out.println("\n[출판물 통계 분석]");

        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();

        analyzer.printStatistics(publications);
        
        // 1. ShoppingCart 객체를 생성합니다.
        ShoppingCart cart = new ShoppingCart();

        // 2. 다양한 출판물을 장바구니에 추가합니다.
        for (Publication item : publications) {
            cart.addItem(item);
        }

        // 3. 장바구니 내용을 출력합니다.
        System.out.println("\n[장바구니 내용]");
        cart.displayCart();

        // 4. 통계를 출력합니다.
        cart.printStatistics();

        // 5. '빠삐용' 항목을 제거합니다.
        System.out.println("\n[빠삐용 제거]");
        cart.removeItem("빠삐용");

        // 6. 변경된 장바구니 내용을 다시 출력합니다.
        System.out.println("\n[변경된 장바구니 내용]");
        cart.displayCart();
        
	}
	
	public static void modifyPrice(Publication publication) { 
		int currentPrice = publication.getPrice(); 
		// instanceof로 실제 객체 타입 확인 후 차별적 할인 적용 
		if (publication instanceof Magazine) { 
			publication.setPrice((int)(currentPrice * 0.6)); // 40% 할인 
		} else if (publication instanceof Novel) { 
			publication.setPrice((int)(currentPrice * 0.8)); // 20% 할인 
		} else if (publication instanceof ReferenceBook) { 
			publication.setPrice((int)(currentPrice * 0.9)); // 10% 할인 } 
		}
	}

}
