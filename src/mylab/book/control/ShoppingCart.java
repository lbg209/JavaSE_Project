package mylab.book.control;

import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ShoppingCart {
	
	private List<Publication> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}
	
	//장바구니에 출판물을 추가하고 추가 메시지를 출력합니다.
	public void addItem(Publication item) { 
		items.add(item); 
		System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다."); 
    }
	
	// 제목으로 출판물을 검색하여 장바구니에서 제거합니다. 제거 성공 시 true, 실패 시 false를 반환합니다.
	public boolean removeItem(String title) { 
		for (int i = 0; i < items.size(); i++) { 
		
			if (items.get(i).getTitle().equals(title)) { 
				Publication removed = items.remove(i); 
				System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다."); 
				return true; // 성공적으로 제거됨 } 
			}
		}
		System.out.println("해당 제목의 출판물을 찾을 수 없습니다."); 
	    
		return false; // 제거 실패 
	}


	// displayCart(): 장바구니의 내용을 항목별로 출력하고, 총 가격과 할인 적용 가격도 표시합니다.

	public void displayCart() {
        System.out.println("====== 장바구니 목록 ======");

        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            for (Publication item : items) {
                System.out.println("제목: " + item.getTitle());
                System.out.println("가격: " + item.getPrice() + "원");
                System.out.println("----------------------");
            }
        }

        System.out.println("총 가격: " + calculateTotalPrice() + "원");
        System.out.println("할인 적용 가격: "
                + calculateDiscountedPrice() + "원");
    }
	
	//장바구니에 있는 모든 출판물의 원래 가격을 합산하여 반환합니다.
	 // 모든 출판물의 원래 가격 합산
    public int calculateTotalPrice() {
        int total = 0;

        for (Publication item : items) {
            total += item.getPrice();
        }

        return total;
    }
    
	//출판물 타입에 따라 다른 할인율을 적용하여 총 할인가를 계산합니다: 

	public int calculateDiscountedPrice() { 
	    int total = 0; 
	    for (Publication item : items) { 
	        // ManageBook과는 다른 할인율 적용 (용도별 차별화) 
	        if (item instanceof Magazine) { 
	            total += item.getPrice() * 0.9; // 10% 할인 
	        } else if (item instanceof Novel) { 
	            total += item.getPrice() * 0.85; // 15% 할인 
	        } else if (item instanceof ReferenceBook) { 
	            total += item.getPrice() * 0.8; // 20% 할인 
	        } else { 
	            total += item.getPrice(); // 기본 출판물은 할인 없음 
	    } 
	} 
	  return total; 
	}
	
	//장바구니에 담긴 출판물들의 타입별 통계(수량)를 출력합니다.

	public void printStatistics() { 
		int magazineCount = 0; 
	    int novelCount = 0; 
	    int referenceBookCount = 0; // instanceof를 활용한 타입별 카운팅 
	    for (Publication item : items) { 
	        if (item instanceof Magazine) {
	        	magazineCount++; 
	        } else if (item instanceof Novel) {
	        	novelCount++; 
	        } else if (item instanceof ReferenceBook) {
	            referenceBookCount++; 
	        } 
	    }
	}


}
