Program Details
Project title: Topic Modeller
Author: C18444694	

My Topic Modeller takes in 3 files and then displays the 8 most common words from each file and there count,
A grade is produced of how likely they are to be related based on the overlapping words in the most common words
You can remove any stop words from the common words if you want, results are then wrote to a file called results.txt

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

What I would Change?
If I had more time I could enhance the program and make it even more useful than it already is, at the moment its main
focus is "txt" files, I would modify it so that it can take any file and read from it, including files that contain
images. I would also make it more accurate , in that words that have similar meaning but are different I could group them
together. I plan to try make it so that it can work on the web and you can see if news articles are related or if websites are related.
Even further down the line I could make it a chrome extension and anybody could use it.


YT Link:
https://youtu.be/KKAZ6FqJRIE