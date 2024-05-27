package com.kh.springProject.common.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
	private int listCount; // �� �Խñ� ����
	private int currentPage; // ���� ������
	private int pageLimit; // ������ �ϴܿ� ������ ����¡�ٿ� �ִ� ����
	private int boardLimit; // �� �������� ������ �Խñ� ����

	private int maxPage; // ���� ������ ����¡�ٰ� ������� (�� ������ ����)
	private int startPage; // ������ �ϴܿ� ������ ����¡���� ���ۼ�
	private int endPage; // ������ �ϴܿ� ������ ����¡���� ����
}
