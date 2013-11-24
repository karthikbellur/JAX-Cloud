#include<stdio.h>

#include<unistd.h>

#include<stdlib.h>

#include<string.h>

#include<fcntl.h>



int file_exists(char filename[])

{

    FILE *file;

    if (file = fopen(filename, "r"))

    {

        fclose(file);

        return 1;

    }

    return 0;

}



int isExecutable(char filename[])

{

FILE *fp=fopen(filename,"r");

int c;

while(fp != NULL)

{

c = fgetc(fp);

if(c != EOF && c <= 127)

continue;

else

break;

}



fclose(fp);

if(c == EOF) 

return 0;

else

return 1;

}



int main(int argc,char *argv[])

{

char outputExe[500] = {"/JAXCloud/shared/users/"};

char outputTxt[500] = {"/JAXCloud/shared/users/"};

char outputSubDir[250] = {"code_execution/output/"};

char inputSubDir[250] = {"code_execution/input/"};

char compileCommand[500] = {"gcc -o "};

char mvCmd[500] = {"cat "};

char compileFlags[100] = {};

char removeCommand[500] = {"rm "};

char filename[100]={};

char uid[40]={};

char compileMarker[500] = {"echo ***************COMPILER OUTPUT***************>"};

char outputMarker[500] = {"echo ***************EXECUTION OUTPUT***************>>"};

char chmod[100] = {"chmod 777 "};

strcpy(filename,argv[0]);

strcpy(uid,argv[1]);

strcpy(compileFlags,argv[2]);

strcat(uid,"/");



strcat(outputTxt,uid);

strcat(outputTxt,outputSubDir);

strcat(outputTxt,filename);

strcat(outputTxt,".txt");



strcat(outputExe,uid);

strcat(outputExe,outputSubDir);

strcat(outputExe,filename);



strcat(compileCommand,outputExe);

strcat(compileCommand," /JAXCloud/shared/users/");

strcat(compileCommand,uid);

strcat(compileCommand,inputSubDir);

strcat(compileCommand,filename);

strcat(compileCommand,".c");

strcat(compileCommand,compileFlags);

strcat(removeCommand, outputExe);



strcat(compileMarker,outputTxt);

printf("Execute : %s\n",compileMarker);

system(compileMarker);

strcat(compileCommand," >> ");

strcat(compileCommand,outputTxt);

strcat(compileCommand," 2>&1 ");

printf("Executing Compile Command : %s\n",compileCommand);

system(compileCommand);



if(file_exists(outputExe) && !isExecutable(outputExe))

{

printf("Output is not an executable\n");

strcat(mvCmd,outputExe); 	

strcat(mvCmd," >> ");

strcat(mvCmd,outputTxt);

printf("Execute : %s\n",mvCmd);

system(mvCmd);

}

else if(file_exists(outputExe))

{

printf("Output is an executable\n");

strcat(outputMarker,outputTxt);

printf("Writing output to file...\n");

system(outputMarker);

strcat(outputExe," >> ");

strcat(outputExe,outputTxt);

strcat(outputExe," 2>&1 ");

printf("Execute : %s\n",outputExe);

system(outputExe);

}



printf("Deleting temp files\n");

printf("Executing Remove Command : %s\n",removeCommand);

system(removeCommand);



strcat(chmod,outputTxt);

system(chmod);

printf("Input C code compilation and execution on Linux Platform completed successfully!!\n");

return 0;

}

