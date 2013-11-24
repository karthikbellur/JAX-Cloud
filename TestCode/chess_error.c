#exclude<stdio1.h>
int queen[9];
int main()
{
	int num=0;


	printf("The whole 64 squares has been divided into 8 columns of \n8 squares each. the first entry tells the row of the \n"); 
	printf("position of the queen in that particular column\nthe second entry tells the row of the queen in the secondcolumn\n");
	printf("Like this, 8 entries per sln are given. \nTwo slns might match if the slns which are identical with respect to\n");
	printf("the diagonals of the board or the centre line of the board");
	printf("\nTotal num of slns is printed at the end\n");   
	for(queen[1]=1;queen[1]<=8;queen[1]++)
	{
	  for(queen[2]=1;queen[2]<=8;queen[2]++)
	  {
	    if(func(2))
	    {
	  for(queen[3]=1;queen[3]<=8;queen[3]++)
	      {
		if(func(3))
		{
	  for(queen[4]=1;queen[4]<=8;queen[4]++)
		  {
		    if(func(4))
		    {
	  for(queen[5]=1;queen[5]<=8;queen[5]++)
		      {
			if(func(5))
			{
	  for(queen[6]=1;queen[6]<=8;queen[6]++)
			  {
			    if(func(6))
			    {
	  for(queen[7]=1;queen[7]<=8;queen[7]++)
			      {
				if(func(7))
				{
	   for(queen[8]=1;queen[8]<=8;queen[8]++)
				  {
				    if(func(8))
				    {
					printf("sln no %d:   %d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\n\n",++num,queen[1],queen[2],queen[3],queen[4],queen[5],queen[6],queen[7],queen[8]);
				
	}
	}
	}
	}
	}
	}
	}
	}
	}
	}
	}
	}
	}
	}
	}

	printf("\nno of slns=%d\n",num);
	return 0;

}
int func(int numnow)
{
	int i;
	for(i=1;i<numnow;i++)
	{
		if((queen[i]==queen[numnow])||(queen[i]==queen[numnow]+(numnow-i))||(queen[i]==queen[numnow]-(numnow-i)))
			return(0);
	}
	return(1);
}

