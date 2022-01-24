import java.util.Arrays;

public class DestroyingAsteroid {
  public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long psum = mass;
        //find prefix sum of mass
        for(int val : asteroids) {
          if(val > psum) return false;
          psum+=val;
        }
        return true;
  }
}
