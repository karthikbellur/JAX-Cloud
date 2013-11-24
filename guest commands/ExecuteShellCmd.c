#include<stdio.h>
#include<string.h>

int main(int argc,char *argv[])
{
char output[100] = {"/JAXCloud/shared/users/"};
char cmd[100]={};
char uid[40]={};
char pad[100]={};
char commandMarker[500] = {"echo COMMAND : "};
char outputMarker[500] = {"echo *************OUTPUT*************>>"};
char chmod[100] = {"chmod 777 "};

strcpy(pad,argv[2]);
strcpy(uid,argv[1]);
strcat(uid,"/");

strcat(output,uid);
strcat(output,"cmd_execution/");
strcat(output,"CmdOutput_");
strcat(output,pad);
strcat(output,".txt");

strcpy(cmd,argv[0]);
strcat(commandMarker,cmd);
strcat(commandMarker,">");
strcat(commandMarker,output);
system(commandMarker);
strcat(outputMarker,output);
system(outputMarker);
strcat(cmd," >> ");
strcat(cmd,output);
strcat(cmd," 2>&1 ");
system(cmd);

strcat(chmod,output);
system(chmod);
printf("Input Command executed successfully!!!\n");
return 0;
}
