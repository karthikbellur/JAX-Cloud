#include<stdio.h>
#include<string.h>

int main(int argc,char *argv[])
{
char sqlFile[100] = {"/JAXCloud/shared/users/"};
char warFile[100] = {"/JAXCloud/shared/users/"};
char cmd[100]={};
char uid[40]={};
char warFileName[100]={};
char sqlFileName[100]={};
char command[100]= {"echo alliswell | sudo -S cp -f "};
char sqlcommand[100]= {"mysql -h localhost -u root --password=admin < "};
char chmod[200] = {"echo alliswell | sudo -S chmod 777 /var/lib/tomcat6/webapps/"};
char temp[500]={"echo "};

strcpy(sqlFileName,argv[2]);
strcpy(warFileName,argv[1]);
strcpy(uid,argv[0]);
strcat(uid,"/");

strcat(sqlFile,uid);
strcat(warFile,uid);
strcat(sqlFile,"deploy_app/");
strcat(warFile,"deploy_app/");
strcat(warFile,warFileName);
strcat(sqlFile,sqlFileName);

strcat(command,warFile);
strcat(command," /var/lib/tomcat6/webapps");
printf("Execute : %s\n",command);
system(command);
strcat(chmod,warFileName);
printf("Execute : %s\n",chmod);
system(chmod);
strcat(sqlcommand,sqlFile);
system(sqlcommand);
system("echo alliswell | sudo -S /etc/init.d/tomcat6 restart");

return 0;
}