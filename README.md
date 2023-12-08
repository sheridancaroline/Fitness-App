# CSCI 205 Final Project - Fitness Application

## Team 1

## Team Members: 
- Grace Lukan (Scrum Master)

- Caroline Sheridan (Product Owner)

- Dong Hyun Roh (Developer)

- Donovan Coleman (Developer)

- Amanda Agambire (Developer)


## Explanation of Package Structure

Our main directory is org.team1 which contains different subdirectories and classes that are being used for our fitness application. 

- The fitnessappmvc subdirectory contains FitnessAppModel, FitnessAppController, FitnessAppView, and FitnessAppMain. The FitnessAppMain, which uses the view, controller, and model, is responsible for running our fitness application. 
- The calendar subdirectory contains Calendar and Main, which are not fully implemented and integrated into our fitness application. Still, we have included the calendar subdirectory to show how we were working to improve the calendar that is currently being used in our fitness application.
- The various classes that are contained in the main directory are being used by FitnessAppModel and FitnessAppController.



## Summary

This fitness application provides a user friendly interface that encompasses all the essential functions of the fitness app. Moreover, to allow you to tailor your experience according to your needs, the fitness application allows you to use this app either as a registered user (through login or signup) or a guest. If you are just interested in using a calorie calculator and chatbot, you can simply use this application as a guest. However, if you are also interested in using a calendar to keep track of all your workout information and visualize your progress using chart, you will need to use this application as a registered user by logging in or signing up if you do not already have your account. For a registered user, all your workout information will be saved so that you will still have access to it when you use this application in the future.

Explanation of differnet features:

1. Calorie Calculator - This allows user to select types of workout (either walking or running) and enter duration, speed, weight, and height. When entering speed, weight, and height, the user can select units that they prefer. Given all required information, the calore calculator will calculate calorie burned and display the result to the user.

2. Calendar - If you are a registered user, you have access to the calendar to view your past workouts. For any date you select on the calendar, workout information will be displayed if you did any workout on the selected date and saved to the calendar. Otherwise, no workout information will be displayed. Moreover, this calendar feature also allows you to update your calendar by adding workout to any date.

3. ChatBot - You can use chatBot to get suggestions for your workout based on your goal. Enter your name, workout time limit, number of pounds to lose, and the time span to lose weight.  

4. Chart - If you are a registered user, you will have access to this chart feature that gives you a visual representation of how many calories you burned over the past. Using this chart, you can get a better understanding of your workouts. While the chart illustrates the calories burned over time, the data currently being used to generate the chart is just some sample data, not from user information. This would have been completed if we had more time.



## 3rd Party Libraries

1. JavaFX - https://openjfx.io
2. Serialization


## URL to Video Presentation

https://mediaspace.bucknell.edu/media/Team1+Presentation/1_lsfctnt8