
public class MergeSort3way  {
    public static void Sort(Comparable[]a)
    {
        Comparable[]aux=new Comparable[a.length];
        Sort(a,aux,0,a.length);
    }
    private static void Sort (Comparable[]a,Comparable []aux,int lo,int hi)
    {if(hi<=lo)return;
    int mid1=lo+(hi-lo)/3;
    int mid2=lo+((hi-lo)/3)*2+1;
    Sort(a,aux,lo,mid1);
    Sort(a,aux,mid1+1,mid2);
    Sort(a,aux,mid2+1,hi);
    merge(a,aux,lo,mid1,mid2,hi);
        
    }
    private static boolean less(Comparable v, Comparable w) {  return v.compareTo(w) < 0;  }
private static void merge(Comparable []a,Comparable[]aux,int lo,int mid1,int mid2,int hi)
{
    for (int k = lo; k <= hi; k++)
        aux[k] = a[k];
    int i=lo,j=mid1+1,y=mid2+1,l=hi;
    for(int k=0;k<=mid2;y++)
    {  if(i>mid1)a[k]=aux[j++];
        else if(j>mid2)a[k]=aux[j++];
        else if(less(aux[j],aux[i]))a[k]=aux[j++];
        else a[k]=aux[i++];}
    for(int k=0;k<=hi;k++)
    {
        if(i>mid2)a[k]=aux[y++];
        else if(y>hi)aux[k]=aux[i++];
        else if(less(aux[y],aux[i]))a[k]=aux[y++];
        else a[k]=aux[i];
    }
        

}
}
