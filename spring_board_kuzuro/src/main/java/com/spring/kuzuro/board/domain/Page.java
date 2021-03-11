package com.spring.kuzuro.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter @Setter
@ToString
public class Page {
	// 현재 페이지 번호
	@Setter private int num;
	// 게시물 총 갯수
	@Getter private int count;
	// 화면에 출력할 게시물 수
	@Getter private int postNum = 10;
	// 하단 페이징 번호([게시물 총 갯수 / 한 페이지에 출력 할 갯수] 의 올림)
	@Getter private int pageNum;
	// 출력할 게시물의 첫번째 번호
	@Getter private int displayPost;
	// 한번에 표시 할 페이징 번호의 갯수
	@Getter private int pageNumCnt = 10;
	// 표시되는 페이지 번호 중 마지막 번호
	@Getter private int endPageNum;
	// 표시되는 페이지 번호 중 첫번째 번호
	@Getter private int startPageNum;
	// 이전/다음 표시 여부
	@Getter private boolean prev;
	@Getter private boolean next;
	// 처음/마지막 표시 여부
	private boolean first;
	private boolean last;
	
	public void setCount(int count) {
		this.count = count;
		dataCalc();
	}
	
	private void dataCalc() {
		// 마지막 번호
		endPageNum = (int) (Math.ceil((double)num/(double)pageNumCnt) * pageNumCnt);
		// 시작 번호
		startPageNum = endPageNum - (pageNumCnt - 1);
		// 마지막 번호 재계산
		int endPageNum_tmp = (int) (Math.ceil((double)count/(double)pageNumCnt));
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		prev = startPageNum == 1 ? false : true;
		next = endPageNum * pageNumCnt >= count ? false : true;
		
		displayPost = (num - 1) * postNum;
	}
}
