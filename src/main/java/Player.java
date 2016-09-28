import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class Player {
  private int id;
  private String name;
  private String email;

  public Player(String name, String email) {
    this.name = name;
    this.email = email;
    this.save();
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object otherPlayer) {
    if (!(otherPlayer instanceof Player)) {
      return false;
    } else {
      Player newPlayer = (Player) otherPlayer;
      return this.getName().equals(newPlayer.getName()) &&
             this.getEmail().equals(newPlayer.getEmail());
    }
  }

  public void save() {
    String sql = "INSERT INTO players (name, email) VALUES (:name, :email)";
    try(Connection cn = DB.sql2o.open()) {
      this.id = (int) cn.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("email", this.email)
        .executeUpdate()
        .getKey();
    }
  }

  public static Player find(int id) {
    String sql = "SELECT * FROM players where id=:id";
    try(Connection cn = DB.sql2o.open()) {
      Player player = cn.createQuery(sql)
        .addParameter("id",id)
        .executeAndFetchFirst(Player.class);
      return player;
    }
  }

  public static List<Player> all() {
    String sql = "SELECT * FROM players";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Player.class);
    }
  }

  public List<Object> getPets() {
    List<Object> allPets = new ArrayList<Object>();
    try(Connection cn = DB.sql2o.open()) {
      String sql = "SELECT * FROM pets WHERE playerId=:id AND type=1;";
      List<BugPet> bugPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(BugPet.class);
        allPets.addAll(bugPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=2;";
      List<DarkPet> darkPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(DarkPet.class);
        allPets.addAll(darkPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=3;";
      List<DragonPet>dragonPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(DragonPet.class);
        allPets.addAll(dragonPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=4;";
      List<ElectricPet> electricPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(ElectricPet.class);
        allPets.addAll(electricPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=5;";
      List<FairyPet> fairyPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(FairyPet.class);
        allPets.addAll(fairyPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=6;";
      List<FightingPet>fightingPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(FightingPet.class);
        allPets.addAll(fightingPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=7;";
      List<FirePet> firePets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(FirePet.class);
        allPets.addAll(firePets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=8;";
      List<FlyingPet> flyingPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(FlyingPet.class);
        allPets.addAll(flyingPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=9;";
      List<GhostPet> ghostPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(GhostPet.class);
        allPets.addAll(ghostPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=10;";
      List<GrassPet> grassPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(GrassPet.class);
        allPets.addAll(grassPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=10;";
      List<GroundPet> groundPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(GroundPet.class);
        allPets.addAll(groundPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=12;";
      List<IcePet> icePets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(IcePet.class);
        allPets.addAll(icePets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=13;";
      List<NormalPet> normalPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(NormalPet.class);
        allPets.addAll(normalPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=14;";
      List<PoisonPet> poisonPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(PoisonPet.class);
        allPets.addAll(poisonPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=15;";
      List<PsychicPet> psychicPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(PsychicPet.class);
        allPets.addAll(psychicPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=16;";
      List<RockPet> rockPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(RockPet.class);
        allPets.addAll(rockPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=17;";
      List<SteelPet> steelPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(SteelPet.class);
        allPets.addAll(steelPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=18;";
      List<UnknownPet> unknownPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(UnknownPet.class);
        allPets.addAll(unknownPets);

      sql = "SELECT * FROM pets WHERE playerId=:id AND type=19;";
      List<WaterPet> waterPets = cn.createQuery(sql)
        .addParameter("id", this.id)
        .throwOnMappingFailure(false)
        .executeAndFetch(WaterPet.class);
        allPets.addAll(waterPets);

      return allPets;

    }
  }

}
