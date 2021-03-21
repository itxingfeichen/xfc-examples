package com.github.xfc.web;

import java.util.Scanner;

public class duijupipei {
	public static void main(String[] args) {
		int res = 0;
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		int k = cin.nextInt();
		int[] val = new int[100001];
		//如果k不等于0，
		for(int i=0;i<N;i++) {
			val[cin.nextInt()]++;
		}
		cin.close();
		if(k==0) {
			for(int i=0;i<100001;i++) {
				if(val[i]!=0) res++;
			}
		}
		else {
			//一个组，每次循环，重新利用这个组
			int[] agroup = new int[100001];
			int[] dp = new int[100001];
			//一共有k个组，循环每组，找出能过匹配的最大的人数
			for(int i=0;i<k;i++) {
				int len = 1;
				for(int j=i;j<100001;j+=k) {
					//当前组的第len个值为val[j]
					agroup[len++] = val[j];
				}
				dp[0] = 0;dp[1] = agroup[1];
				for(int j=2;j<len;j++) {
					dp[j] = Math.max(dp[j-1], dp[j-2]+agroup[j]);
				}
				res += dp[len-1];
			}
		}
		System.out.println(res);
		
	}


}