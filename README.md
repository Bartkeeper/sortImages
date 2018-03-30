# sortImages

This file sorts your images based on the filename's timestamp and copies them into Year/Month folders. 
Here's a guide on how to deal with it:

1. Open the sortImages.txt file and enter the path where the sortImages.jar file is stored after "cd" in the same line
2. Safe this file als .txt file and as .bat file.
3. Execute the .bat file you have saved in step 3.
4. While executing, you will be asked 4 questions:

  4.1.: Enter the folder's path, where your images you want to sort are stored.
  4.2.: Enter the year of the oldest image. If e.g. the oldest image was taken (depening on the files timestamp) was in 2015, just enter 2015
  4.3.: Now enter the your of the most recent image like you did in step 3.
  4.4.: This is important: Look on the name of your files and enter the charakter before the timestamp in your files' names.
  
  Example:  IMG-20160822-WA0005.jpg --> Enter: "-"
            IMG_20171227_000157.jpg --> Enter: "_"
            
Now the programm will execute, which takes a few seconds. After this you can find your files stored in the year- and month-folders.



Please be aware that it only contains basic functions and that your entries MUST be correct in order to have a successful processing.

In my next step i will add an exception-handling that will avoid incorrect processing.

If you have questions or hints how my programm could be improved, just send me a message.
