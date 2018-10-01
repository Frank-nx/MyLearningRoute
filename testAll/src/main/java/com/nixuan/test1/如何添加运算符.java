package com.nixuan.test1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-09-27 14:41
 *
 * //分别将四个符号依次放入符号数组
 *         for(myMark[0]=0;myMark[0]<4;myMark[0]++){
 *             if(myMark[0]<3||num[1]!=0){
 *             for(myMark[1]=0;myMark[1]<4;myMark[1]++){
 *                 if(myMark[1]<3||num[2]!=0){
 *                 for(myMark[2]=0;myMark[2]<4;myMark[2]++){
 *                     if(myMark[2]<3||num[3]!=0){
 *                     for(myMark[3]=0;myMark[3]<4;myMark[3]++){
 *                         if(myMark[3]<3||num[4]!=0){
 *                         left=0;
 *                         right=num[0];
 *                         sign=1;//初始为正数
 *                         for(int j=0;j<4;j++){
 *                             switch(mark[myMark[j]]){
 *                                 case'+':
 *                                     left=left+sign*right;
 *                                     sign=1;
 *                                     right=num[j+1];
 *                                     break;
 *                                 case'-':
 *                                     left=left+sign*right;
 *                                     sign=-1;
 *                                     right=num[j+1];
 *                                     break;
 *                                 case'*':
 *                                     right=right*num[j+1];
 *                                     break;
 *                                 case'/':
 *                                     right=right/num[j+1];
 *                                     break;
 *                             }
 *
 *                         }
 *                         if(left+sign*right==result){
 *                             count++;
 *                             printf("%3d:",count);
 *                             for(int j=0;j<4;j++){
 *                                 printf("%d%c",num[j],mark[myMark[j]]);
 *                             }
 *                                 printf("%d=%d\n",num[4],result);
 *
 *                           }
 *                         }
 *                       }
 *                     }
 *                   }
 *                 }
 *               }
 *             }
 *         }
 *
 *     return 0;
 * }
 *
 **/
