import org.sql2o.*;
import java.util.List;
import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;

public class FlyingPet extends Pet implements DatabaseManagement {
  private int specialLevel;
  public static final int PET_TYPE=8;
  public static final int MAX_SPECIAL_LEVEL = 8;

  public FlyingPet(String name, int playerId) {
    this.name = name;
    this.playerId = playerId;
    type=PET_TYPE;
    foodLevel=MAX_FOOD_LEVEL/2;
    sleepLevel=MAX_SLEEP_LEVEL/2;
    playLevel=MAX_PLAY_LEVEL/2;
    specialLevel=MAX_SPECIAL_LEVEL/2;
    timer = new Timer();
    save();
  }




  public int getSpecialLevel() {
    return specialLevel;
  }

  public void special() {
    if(specialLevel >= MAX_SPECIAL_LEVEL) {
      throw new UnsupportedOperationException ("Even special pets can get too much attention - back off!");
    }
    specialLevel++;
  }

  public static List<FlyingPet> all() {
    String sql = "SELECT * FROM pets WHERE type=8";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).throwOnMappingFailure(false).executeAndFetch(FlyingPet.class);
    }
  }

  public static FlyingPet find(int id) {
    String sql = "SELECT * FROM pets WHERE id=:id";
    try(Connection cn = DB.sql2o.open()) {
      FlyingPet pet = cn.createQuery(sql)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(FlyingPet.class);
      return pet;
    }
  }

}
