Program Details
Project title: Topic Modeller
Author: C18444694	

My program has 7 classes : FileChooser, FileResults, FileManager, ResultsWriter, Stop Words, Control and Analyse

FileChooser class is the opening screen GUI , it allows the user to enter 3 files into a GUI so that they can be searched.
This class recieves a hashmap and enters them into table also.

FileResults is the GUI that shows the results of the search, it contains 3 sorted tables of the 8 most frequent words
from each file. Followed by a final grade and the option to remove common stop words from the tables if the words are
not informative. Final Results will be written to a file also.

Results Writer is the class that writes the final results to a file called results.txt. Writes the tables and the final
grade to the file.

The FileManager class makes a connection to the file that is entered, it reads the files and enters each word into a 
hashmap and there count. The hash map is then sorted into a new hashmap and then the sorted map is returned to where its called

Stop Words class reads a file caled stopwords.txt that contains all non informative words that cant be related to a topic
If a stop word is in the hashmap it is then removed from the hashmap so there are no stop words in the hashmap

Analyse class is the class where the overlapping percentage is calculated, the tables are passed in and added to one big 
hashmap and each word is counted to see if they overlap. A percentage is then produced based on how many times a word appears in each table

Control Class contains the main so that is where the program is ran from.

YT Link:
https://youtu.be/KKAZ6FqJRIE