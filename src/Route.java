public class Route {
    static int getIndex(int path[][], int x, int y){
        int i;
        int[] array = {x, y};
        for(i=0; i<path.length; i++){
            if(path[i]==array){
                return i;
            }
        }
        return -1;
        
    }
    
} 