# Rewards Reference Domain

This section provides an overview of the domain and the applications you will be working on within it.

# Domain Overview

The Domain is called Reward Dining. The idea is that customers can save money every time they eat at one of the restaurants participating in the network - a "Frequent Flyer" program for restaurants.

For example, Keith would like to save money for his children's education. Every time he dines at a restaurant participating in the network, a contribution is made to his account.

Papa Keith dines at a restaurant in the Reward Network

The account contribution (reward) will be shared by his two children Annabelle and Corgan. Thus Annabelle gets a fund to help her with her college fees

# Reward Dining Domain Applications

This next section provides an overview of the applications in the Reward Dining domain that you will be working on in this course.

@ The Rewards Application

The "rewards" application rewards an account for dining at a restaurant participating in the reward network.

Every two weeks, a file containing the dining credit card transactions made by members during that period is generated. A sample of one of these files is shown below:

AMOUNT    CREDIT_CARD_NUMBER    MERCHANT_NUMBER    DATE
----------------------------------------------------------
100.00  1234123412341234    1234567890      12/29/2010
49.67   1234123412341234    0234567891      12/31/2010
100.00  1234123412341234    1234567890      01/01/2010
27.60   2345234523452345    3456789012      01/02/2010

A standalone DiningBatchProcessor application reads this file and submits each Dining record to the rewards application for processing.

    public interface RewardNetwork {
        RewardConfirmation rewardAccountFor(Dining dining);
    }

 #   https://spring.academy/courses/spring-introduction/lessons/spring-introduction-rewards-reference-domain-demo

 











































































