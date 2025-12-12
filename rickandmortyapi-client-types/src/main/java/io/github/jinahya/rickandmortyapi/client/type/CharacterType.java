package io.github.jinahya.rickandmortyapi.client.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import jakarta.json.bind.annotation.JsonbVisibility;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

@JsonbVisibility(___NonPrivateVisibilityStrategy.class)
@Setter(AccessLevel.PROTECTED)
@Getter
public class CharacterType extends BaseSingularType {

    @Serial
    private static final long serialVersionUID = -7867037207488854753L;

    // -------------------------------------------------------------------------------------------------------- $.status
    public static final String JSON_NAME_STATUS = "status";

    public static final String JSON_VALUE_STATUS_ALIVE = "Alive";

    public static final String JSON_VALUE_STATUS_DEAD = "Dead";

    public static final String JSON_VALUE_STATUS_UNKNOWN = "unknown";

    public enum Status implements __BaseEnum<Status> {

        @JsonProperty(JSON_VALUE_STATUS_ALIVE)
        ALIVE(JSON_VALUE_STATUS_ALIVE),

        @JsonProperty(JSON_VALUE_STATUS_DEAD)
        DEAD(JSON_VALUE_STATUS_DEAD),

        @JsonProperty(JSON_VALUE_STATUS_UNKNOWN)
        UNKNOWN(JSON_VALUE_STATUS_UNKNOWN);

        public static Status valueOfValue(final String value) {
            return __BaseEnumUtils.valueOfValue(Status.class, value);
        }

        Status(final String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }

        private final String value;
    }

    public static class StatusAdapter extends __BaseEnumAdapter<Status> {

        public StatusAdapter() {
            super(Status.class);
        }
    }

    // ------------------------------------------------------------------------------------------------------- $.species
    public static final String JSON_NAME_SPECIES = "species";

    public static final String JSON_VALUE_SPECIES_ALIEN = "Alien";

    public static final String JSON_VALUE_SPECIES_ANIMAL = "Animal";

    public static final String JSON_VALUE_SPECIES_CRONENBERG = "Cronenberg";

    public static final String JSON_VALUE_SPECIES_DISEASE = "Disease";

    public static final String JSON_VALUE_SPECIES_HUMAN = "Human";

    public static final String JSON_VALUE_SPECIES_HUMANOID = "Humanoid";

    public static final String JSON_VALUE_SPECIES_MYTHOLOGICAL_CREATURE = "Mythological Creature";

    public static final String JSON_VALUE_SPECIES_POPPYBUTTHOLE = "Poopybutthole";

    public static final String JSON_VALUE_SPECIES_ROBOT = "Robot";

    public static final String JSON_VALUE_SPECIES_UNKNOWN = "unknown";

    public enum Species implements __BaseEnum<Species> {
        // Alien, Animal, Cronenberg, Disease, Human, Humanoid, Mythological Creature, Poopybutthole, Robot, unknown

        @JsonProperty(JSON_VALUE_SPECIES_ALIEN)
        ALIEN(JSON_VALUE_SPECIES_ALIEN),

        @JsonProperty(JSON_VALUE_SPECIES_ANIMAL)
        ANIMAL(JSON_VALUE_SPECIES_ANIMAL),

        @JsonProperty(JSON_VALUE_SPECIES_CRONENBERG)
        CRONENBERG(JSON_VALUE_SPECIES_CRONENBERG),

        @JsonProperty(JSON_VALUE_SPECIES_DISEASE)
        DISEASE(JSON_VALUE_SPECIES_DISEASE),

        @JsonProperty(JSON_VALUE_SPECIES_HUMAN)
        HUMAN(JSON_VALUE_SPECIES_HUMAN),

        @JsonProperty(JSON_VALUE_SPECIES_HUMANOID)
        HUMANOID(JSON_VALUE_SPECIES_HUMANOID),

        @JsonProperty(JSON_VALUE_SPECIES_MYTHOLOGICAL_CREATURE)
        MYTHOLOGICAL_CREATURE(JSON_VALUE_SPECIES_MYTHOLOGICAL_CREATURE),

        @JsonProperty(JSON_VALUE_SPECIES_POPPYBUTTHOLE)
        POPPYBUTTHOLE(JSON_VALUE_SPECIES_POPPYBUTTHOLE),

        @JsonProperty(JSON_VALUE_SPECIES_ROBOT)
        ROBOT(JSON_VALUE_SPECIES_ROBOT),

        @JsonProperty(JSON_VALUE_SPECIES_UNKNOWN)
        UNKNOWN(JSON_VALUE_SPECIES_UNKNOWN);

        public static Species valueOfValue(final String value) {
            return __BaseEnumUtils.valueOfValue(Species.class, value);
        }

        Species(final String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }

        private final String value;
    }

    public static class SpeciesAdapter extends __BaseEnumAdapter<Species> {

        public SpeciesAdapter() {
            super(Species.class);
        }
    }

    // ---------------------------------------------------------------------------------------------------------- $.type
    public static final String JSON_NAME_TYPE = "type";

    static final String JSON_VALUE_TYPE_ALLIGATOR_PERSON = "Alligator_Person";

    static final String JSON_VALUE_TYPE_ALPHABETRIAN = "Alphabetrian";

    static final String JSON_VALUE_TYPE_AMOEBA_PERSON = "Amoeba_Person";

    static final String JSON_VALUE_TYPE_ANIMAL = "Animal";

    static final String JSON_VALUE_TYPE_ANIME = "Anime";

    static final String JSON_VALUE_TYPE_ARTIFICIAL_INTELLIGENCE = "Artificial Intelligence";

    static final String JSON_VALUE_TYPE_BEPISIAN = "Bepisian";

    static final String JSON_VALUE_TYPE_BIRD_PERSON = "Bird_Person";

    static final String JSON_VALUE_TYPE_BIRD_PERSON_HUMAN_MIX = "Bird_Person Human Mix";

    static final String JSON_VALUE_TYPE_BLUE_APE_ALIEN = "Blue ape alien";

    static final String JSON_VALUE_TYPE_BOOBIE_BUYER_REPTILIAN = "Boobie buyer reptilian";

    static final String JSON_VALUE_TYPE_BOOBLOOSIAN = "Boobloosian";

    static final String JSON_VALUE_TYPE_BREAD = "Bread";

    static final String JSON_VALUE_TYPE_CHUD = "CHUD";

    static final String JSON_VALUE_TYPE_CHUD_HUMAN_MIX = "CHUD Human Mix";

    static final String JSON_VALUE_TYPE_CAT = "Cat";

    static final String JSON_VALUE_TYPE_CAT_CONTROLLED_DEAD_LADY = "Cat controlled dead lady";

    static final String JSON_VALUE_TYPE_CAT_PERSON = "Cat_Person";

    static final String JSON_VALUE_TYPE_CATERPILLAR = "Caterpillar";

    static final String JSON_VALUE_TYPE_CENTAUR = "Centaur";

    static final String JSON_VALUE_TYPE_CHAIR = "Chair";

    static final String JSON_VALUE_TYPE_CHANGEFORMER = "Changeformer";

    static final String JSON_VALUE_TYPE_CLAY_PERSON = "Clay_Person";

    static final String JSON_VALUE_TYPE_CLONE = "Clone";

    static final String JSON_VALUE_TYPE_CONE_NIPPLED_ALIEN = "Cone_nippled alien";

    static final String JSON_VALUE_TYPE_CONJOINED_TWIN = "Conjoined twin";

    static final String JSON_VALUE_TYPE_COOKIE = "Cookie";

    static final String JSON_VALUE_TYPE_CORN_PERSON = "Corn_person";

    static final String JSON_VALUE_TYPE_CROMULON = "Cromulon";

    static final String JSON_VALUE_TYPE_CRONENBERG = "Cronenberg";

    static final String JSON_VALUE_TYPE_CROW = "Crow";

    static final String JSON_VALUE_TYPE_CROW_HORSE = "Crow Horse";

    static final String JSON_VALUE_TYPE_CYBORG = "Cyborg";

    static final String JSON_VALUE_TYPE_DECOY = "Decoy";

    static final String JSON_VALUE_TYPE_DEMON = "Demon";

    static final String JSON_VALUE_TYPE_DOG = "Dog";

    static final String JSON_VALUE_TYPE_DOOPIDOO = "Doopidoo";

    static final String JSON_VALUE_TYPE_DRAGON = "Dragon";

    static final String JSON_VALUE_TYPE_DRUMBLOXIAN = "Drumbloxian";

    static final String JSON_VALUE_TYPE_DUMMY = "Dummy";

    static final String JSON_VALUE_TYPE_EAT_SHITER_PERSON = "Eat shiter_Person";

    static final String JSON_VALUE_TYPE_EEL = "Eel";

    static final String JSON_VALUE_TYPE_ELEPHANT_PERSON = "Elephant_Person";

    static final String JSON_VALUE_TYPE_FERKUSIAN = "Ferkusian";

    static final String JSON_VALUE_TYPE_FERRET_ROBOT = "Ferret Robot";

    static final String JSON_VALUE_TYPE_FISH_PERSON = "Fish_Person";

    static final String JSON_VALUE_TYPE_FLANSIAN = "Flansian";

    static final String JSON_VALUE_TYPE_FLOOP_FLOOPIAN = "Floop Floopian";

    static final String JSON_VALUE_TYPE_FLY = "Fly";

    static final String JSON_VALUE_TYPE_GAME = "Game";

    static final String JSON_VALUE_TYPE_GARBLOVIAN = "Garblovian";

    static final String JSON_VALUE_TYPE_GAZORPIAN = "Gazorpian";

    static final String JSON_VALUE_TYPE_GAZORPIAN_REPRODUCTION_ROBOT = "Gazorpian reproduction robot";

    static final String JSON_VALUE_TYPE_GEAR_PERSON = "Gear_Person";

    static final String JSON_VALUE_TYPE_GENETIC_EXPERIMENT = "Genetic experiment";

    static final String JSON_VALUE_TYPE_GIANT = "Giant";

    static final String JSON_VALUE_TYPE_GIANT_CAT_MONSTER = "Giant Cat Monster";

    static final String JSON_VALUE_TYPE_GIANT_INCEST_BABY = "Giant Incest Baby";

    static final String JSON_VALUE_TYPE_GLORZO = "Glorzo";

    static final String JSON_VALUE_TYPE_GOD = "God";

    static final String JSON_VALUE_TYPE_GODDESS = "Goddess";

    static final String JSON_VALUE_TYPE_GRAMUFLACKIAN = "Gramuflackian";

    static final String JSON_VALUE_TYPE_GRANDMA = "Grandma";

    static final String JSON_VALUE_TYPE_GREEBYBOBE = "Greebybobe";

    static final String JSON_VALUE_TYPE_GROMFLOMITE = "Gromflomite";

    static final String JSON_VALUE_TYPE_GUINEA_PIG_FOR_THE_POLIO_VACCINE = "Guinea Pig for the Polio Vaccine";

    static final String JSON_VALUE_TYPE_HAIRY_ALIEN = "Hairy alien";

    static final String JSON_VALUE_TYPE_HALF_SOULLESS_PUPPET = "Half Soulless Puppet";

    static final String JSON_VALUE_TYPE_HAMMERHEAD_PERSON = "Hammerhead_Person";

    static final String JSON_VALUE_TYPE_HIVEMIND = "Hivemind";

    static final String JSON_VALUE_TYPE_HOLE = "Hole";

    static final String JSON_VALUE_TYPE_HOLOGRAM = "Hologram";

    static final String JSON_VALUE_TYPE_HUMAN_GAZORPIAN = "Human Gazorpian";

    static final String JSON_VALUE_TYPE_HUMAN_WITH_A_FLOWER_IN_HIS_HEAD = "Human with a flower in his head";

    static final String JSON_VALUE_TYPE_HUMAN_WITH_ANTENNAE = "Human with antennae";

    static final String JSON_VALUE_TYPE_HUMAN_WITH_ANTS_IN_HIS_EYES = "Human with ants in his eyes";

    static final String JSON_VALUE_TYPE_HUMAN_WITH_BABY_LEGS = "Human with baby legs";

    static final String JSON_VALUE_TYPE_HUMAN_WITH_GIANT_HEAD = "Human with giant head";

    static final String JSON_VALUE_TYPE_HUMAN_WITH_TUSKS = "Human with tusks";

    static final String JSON_VALUE_TYPE_HUMAN_SNAKE_HYBRID = "Human_Snake hybrid";

    static final String JSON_VALUE_TYPE_INTERDIMENSIONAL_GASEOUS_BEING = "Interdimensional gaseous being";

    static final String JSON_VALUE_TYPE_JELLYBEAN = "Jellybean";

    static final String JSON_VALUE_TYPE_KORBLOCK = "Korblock";

    static final String JSON_VALUE_TYPE_KROOTABULAN = "Krootabulan";

    static final String JSON_VALUE_TYPE_LARVA_ALIEN = "Larva alien";

    static final String JSON_VALUE_TYPE_LEPRECHAUN = "Leprechaun";

    static final String JSON_VALUE_TYPE_LIGHT_BULB_ALIEN = "Light bulb_Alien";

    static final String JSON_VALUE_TYPE_LITTLE_HUMAN = "Little Human";

    static final String JSON_VALUE_TYPE_LIZARD = "Lizard";

    static final String JSON_VALUE_TYPE_LIZARD_PERSON = "Lizard_Person";

    static final String JSON_VALUE_TYPE_LOBSTER_ALIEN = "Lobster_Alien";

    static final String JSON_VALUE_TYPE_MANNIE = "Mannie";

    static final String JSON_VALUE_TYPE_MASCOT = "Mascot";

    static final String JSON_VALUE_TYPE_MEESEEKS = "Meeseeks";

    static final String JSON_VALUE_TYPE_MEGA_GARGANTUAN = "Mega Gargantuan";

    static final String JSON_VALUE_TYPE_MEMORY = "Memory";

    static final String JSON_VALUE_TYPE_MEXICAN = "Mexican";

    static final String JSON_VALUE_TYPE_MICROVERSE_INHABITANT = "Microverse inhabitant";

    static final String JSON_VALUE_TYPE_MINIVERSE_INHABITANT = "Miniverse inhabitant";

    static final String JSON_VALUE_TYPE_MONOGATRON = "Monogatron";

    static final String JSON_VALUE_TYPE_MONSTER = "Monster";

    static final String JSON_VALUE_TYPE_MORGLUTZIAN = "Morglutzian";

    static final String JSON_VALUE_TYPE_MORTYS_TOXIC_SIDE = "Morty's toxic side";

    static final String JSON_VALUE_TYPE_MYTHOLOG = "Mytholog";

    static final String JSON_VALUE_TYPE_NANO_ALIEN = "Nano Alien";

    static final String JSON_VALUE_TYPE_NARNIAN = "Narnian";

    static final String JSON_VALUE_TYPE_NECROPHILIAC = "Necrophiliac";

    static final String JSON_VALUE_TYPE_NORMAL_SIZE_BUG = "Normal Size Bug";

    static final String JSON_VALUE_TYPE_NUMBERICON = "Numbericon";

    static final String JSON_VALUE_TYPE_OCTOPUS_PERSON = "Octopus_Person";

    static final String JSON_VALUE_TYPE_OLD_AMAZONS = "Old Amazons";

    static final String JSON_VALUE_TYPE_OMNISCIENT_BEING = "Omniscient being";

    static final String JSON_VALUE_TYPE_ORGANIC_GUN = "Organic gun";

    static final String JSON_VALUE_TYPE_PARASITE = "Parasite";

    static final String JSON_VALUE_TYPE_PASSING_BUTTER_ROBOT = "Passing Butter Robot";

    static final String JSON_VALUE_TYPE_PHONE = "Phone";

    static final String JSON_VALUE_TYPE_PHONE_PERSON = "Phone_Person";

    static final String JSON_VALUE_TYPE_PICKLE = "Pickle";

    static final String JSON_VALUE_TYPE_PIZZA = "Pizza";

    static final String JSON_VALUE_TYPE_PLANET = "Planet";

    static final String JSON_VALUE_TYPE_PLUTONIAN = "Plutonian";

    static final String JSON_VALUE_TYPE_PRIPUDLIAN = "Pripudlian";

    static final String JSON_VALUE_TYPE_RAT = "Rat";

    static final String JSON_VALUE_TYPE_RICKS_TOXIC_SIDE = "Rick's toxic side";

    static final String JSON_VALUE_TYPE_RING_NIPPLED_ALIEN = "Ring_nippled alien";

    static final String JSON_VALUE_TYPE_ROBOT = "Robot";

    static final String JSON_VALUE_TYPE_ROBOT_CROCODILE_HYBRID = "Robot_Crocodile hybrid";

    static final String JSON_VALUE_TYPE_SCARECROW = "Scarecrow";

    static final String JSON_VALUE_TYPE_SCROTIAN = "Scrotian";

    static final String JSON_VALUE_TYPE_SELF_AWARE_ARM = "Self_aware arm";

    static final String JSON_VALUE_TYPE_SENTIENT_ANT_COLONY = "Sentient ant colony";

    static final String JSON_VALUE_TYPE_SEXY_AQUAMAN = "Sexy Aquaman";

    static final String JSON_VALUE_TYPE_SHAPESHIFTER = "Shapeshifter";

    static final String JSON_VALUE_TYPE_SHIMSHAMIAN = "Shimshamian";

    static final String JSON_VALUE_TYPE_SHRIMP = "Shrimp";

    static final String JSON_VALUE_TYPE_SLARTIVARTIAN = "Slartivartian";

    static final String JSON_VALUE_TYPE_SLUG = "Slug";

    static final String JSON_VALUE_TYPE_SNAIL_ALIEN = "Snail alien";

    static final String JSON_VALUE_TYPE_SNAKE = "Snake";

    static final String JSON_VALUE_TYPE_SOULLESS_PUPPET = "Soulless Puppet";

    static final String JSON_VALUE_TYPE_SQUID = "Squid";

    static final String JSON_VALUE_TYPE_STAIR_GOBLIN = "Stair goblin";

    static final String JSON_VALUE_TYPE_STARFISH = "Starfish";

    static final String JSON_VALUE_TYPE_SUMMON = "Summon";

    static final String JSON_VALUE_TYPE_SUPER_SPERM_MONSTER = "Super Sperm Monster";

    static final String JSON_VALUE_TYPE_SUPERHUMAN = "Superhuman";

    static final String JSON_VALUE_TYPE_SUPERHUMAN_GHOST_TRAINS_SUMMONER = "Superhuman (Ghost trains summoner)";

    static final String JSON_VALUE_TYPE_TEDDY_BEAR = "Teddy Bear";

    static final String JSON_VALUE_TYPE_TEENYVERSE_INHABITANT = "Teenyverse inhabitant";

    static final String JSON_VALUE_TYPE_TENTACLE_ALIEN = "Tentacle alien";

    static final String JSON_VALUE_TYPE_THE_DEVIL = "The Devil";

    static final String JSON_VALUE_TYPE_TIGER = "Tiger";

    static final String JSON_VALUE_TYPE_TIME_GOD = "Time God";

    static final String JSON_VALUE_TYPE_TINYMOUTH = "Tinymouth";

    static final String JSON_VALUE_TYPE_TOY = "Toy";

    static final String JSON_VALUE_TYPE_TRAFLORKIAN = "Traflorkian";

    static final String JSON_VALUE_TYPE_TRUNK_PERSON = "Trunk_Person";

    static final String JSON_VALUE_TYPE_TUMBLORKIAN = "Tumblorkian";

    static final String JSON_VALUE_TYPE_TURKEY = "Turkey";

    static final String JSON_VALUE_TYPE_TURKEY_HUMAN_MIX = "Turkey Human Mix";

    static final String JSON_VALUE_TYPE_TUSKFISH = "Tuskfish";

    static final String JSON_VALUE_TYPE_UNKNOWN_NIPPLED_ALIEN = "Unknown_nippled alien";

    static final String JSON_VALUE_TYPE_VAMPIRE = "Vampire";

    static final String JSON_VALUE_TYPE_WASP = "Wasp";

    static final String JSON_VALUE_TYPE_WEASEL = "Weasel";

    static final String JSON_VALUE_TYPE_WHENWOLF = "Whenwolf";

    static final String JSON_VALUE_TYPE_ZEUS = "Zeus";

    static final String JSON_VALUE_TYPE_ZIGERION = "Zigerion";

    static final String JSON_VALUE_TYPE_ZOMBODIAN = "Zombodian";

    // -------------------------------------------------------------------------------------------------------- $.gender
    public static final String JSON_NAME_GENDER = "gender";

    public static final String JSON_VALUE_GENDER_FEMALE = "Female";

    public static final String JSON_VALUE_GENDER_GENDERLESS = "Genderless";

    public static final String JSON_VALUE_GENDER_MALE = "Male";

    public static final String JSON_VALUE_GENDER_UNKNOWN = "unknown";

    public enum Gender implements __BaseEnum<Gender> {

        @JsonProperty(JSON_VALUE_GENDER_FEMALE)
        FEMALE(JSON_VALUE_GENDER_FEMALE),

        @JsonProperty(JSON_VALUE_GENDER_GENDERLESS)
        GENDERLESS(JSON_VALUE_GENDER_GENDERLESS),

        @JsonProperty(JSON_VALUE_GENDER_MALE)
        MALE(JSON_VALUE_GENDER_MALE),

        @JsonProperty(JSON_VALUE_GENDER_UNKNOWN)
        UNKNOWN(JSON_VALUE_GENDER_UNKNOWN);

        public static Gender valueOfValue(final String value) {
            return __BaseEnumUtils.valueOfValue(Gender.class, value);
        }

        Gender(final String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return value;
        }

        private final String value;
    }

    public static class GenderAdapter extends __BaseEnumAdapter<Gender> {

        public GenderAdapter() {
            super(Gender.class);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    @JsonbVisibility(___NonPrivateVisibilityStrategy.class)
    public static class NameAndLink extends __BaseType {

        @Serial
        private static final long serialVersionUID = 7184812096300183319L;

        // -------------------------------------------------------------------------------------------------------------
        public static final String JSON_NAME_NAME = "name";

        public static final String JSON_NAME_URL = "url";

        // ------------------------------------------------------------------------------------------------ CONSTRUCTORS
        protected NameAndLink() {
            super();
        }

        // -------------------------------------------------------------------------------------------- java.lang.Object
        @Override
        public String toString() {
            return super.toString() + '{' +
                    "name=" + name +
                    ",url=" + url +
                    '}';
        }

        @Override
        public boolean equals(final Object obj) {
            if (!(obj instanceof NameAndLink that)) {
                return false;
            }
            return Objects.equals(name, that.name)
                    && Objects.equals(url, that.url);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, url);
        }

        // -------------------------------------------------------------------------------------------------------- name
        public String getName() {
            return name;
        }

        void setName(final String name) {
            this.name = name;
        }

        // --------------------------------------------------------------------------------------------------------- url
        public String getUrl() {
            return url;
        }

        void setUrl(final String url) {
            this.url = url;
        }

        // -------------------------------------------------------------------------------------------------------------
        private String name;

        private String url;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    protected CharacterType() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object
    @Override
    public String toString() {
        return super.toString() + '{' +
                "status=" + status +
                ",species=" + species +
                ",type=" + type +
                ",gender=" + gender +
                ",origin=" + origin +
                ",location=" + location +
                ",image=" + image +
                ",episode=" + episode +
                '}';
    }

    // -----------------------------------------------------------------------------------------------------------------
    public Status getStatus() {
        return status;
    }

    void setStatus(final Status status) {
        this.status = status;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public Species getSpecies() {
        return species;
    }

    void setSpecies(final Species species) {
        this.species = species;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String getType() {
        return type;
    }

    void setType(final String type) {
        this.type = type;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public Gender getGender() {
        return gender;
    }

    void setGender(final Gender gender) {
        this.gender = gender;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public NameAndLink getOrigin() {
        return origin;
    }

    void setOrigin(final NameAndLink origin) {
        this.origin = origin;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public NameAndLink getLocation() {
        return location;
    }

    void setLocation(final NameAndLink location) {
        this.location = location;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String getImage() {
        return image;
    }

    void setImage(final String image) {
        this.image = image;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public List<String> getEpisode() {
        return episode;
    }

    void setEpisode(final List<String> episode) {
        this.episode = episode;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @JsonbTypeAdapter(StatusAdapter.class)
    private Status status;

    @JsonbTypeAdapter(SpeciesAdapter.class)
    private Species species;

    @Nullable
    private String type;

    @JsonbTypeAdapter(GenderAdapter.class)
    private Gender gender;

    private NameAndLink origin;

    private NameAndLink location;

    private String image;

    private List<String> episode;
}
