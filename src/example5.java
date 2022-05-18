import java.util.Scanner;

public class example5 {
    public static void main(String[] args) {

        System.out.println("[안내] TRPG 스타크래프트 시작합니다.");
        System.out.println("[안내] 자신의 유닛 정보를 입력해 주세요.");

        Star_unit my_unit = new Star_unit();                     // 자신의 유닛 my_unit 객체 생성
        my_unit.create_unit();                                   // 유닛 생성 메소드호출(유닛정보 입력받아 저장)
        my_unit.print_unit_info();                               // 유닛정보 출력 메소드 호출

        System.out.println("[안내] 상대의 유닛 정보를 입력해 주세요.");

        Star_unit enemy_unit = new Star_unit();
        enemy_unit.create_unit();                            // 유닛 생성 메소드호출(유닛정보 입력받아 저장)
        enemy_unit.print_unit_info();                        // 유닛 정보 출력 메소드 호출


        my_unit.attack(enemy_unit);           // 공격 수행
        my_unit.attack(enemy_unit);
        my_unit.attack(enemy_unit);
        my_unit.attack(enemy_unit);
        my_unit.attack(enemy_unit);
        my_unit.attack(enemy_unit);

        if (enemy_unit.hp <= 0) {
            System.out.println("[안내] 상대 유닛이 제거되었습니다.");
        }


    }
}

class Star_unit {
    String unit_name = "";
    int dmg = 0;
    int def = 0;
    int hp = 0;

    public void create_unit () {                                // 유닛정보를 입력받아 저장하는 메소드
        Scanner sc = new Scanner(System.in);
        System.out.print("[시스템] 유닛 [이름] 을 입력해 주세요 : ");
        this.unit_name = sc.nextLine();
        System.out.print("[시스템] 유닛 [공격력] 을 입력해 주세요 : ");
        this.dmg = sc.nextInt();
        System.out.print("[시스템] 유닛 [방어력] 을 입력해 주세요 : ");
        this.def = sc.nextInt();
        System.out.print("[시스템] 유닛 [체력] 을 입력해 주세요 : ");
        this.hp = sc.nextInt();
        System.out.println();
        sc.nextLine();
    }

    public void print_unit_info() {                             // 유닛정보 출력 메소드
        System.out.println("[안내] 생성된 유닛 정보는 다음과 같습니다.");
        System.out.println("[안내] " + this.unit_name + " 유닛이 게임에 참여하였습니다.");
        System.out.println("[공격력] : " + this.dmg);
        System.out.println("[방어력] : " + this.def);
        System.out.println("[체력] : " + this.hp);
        System.out.println("========================================");
        System.out.println();
    }

    public void attack(Star_unit enemy) {
        if (enemy.hp <= 0) {                                   // 상대유닛의 체력이 0 이하이면 추가공격 불가
            System.out.println("[안내] 더 이상 공격할 수 없습니다.");
            return;
        }

        System.out.println("[안내] [" + this.unit_name + "]유닛이 [공격] 하였습니다.");
        enemy.hp = enemy.hp - this.dmg + enemy.def;                                 // 공격력 =  자신의 공격력 - 상대의 방어력 으로 정의
        if (enemy.hp <= 0) {                                                       // 체력 최소값 0으로 설정
            enemy.hp = 0;
        }
        System.out.println("상대 유닛 [" + enemy.unit_name + "]의 남은 [체력]은 " + enemy.hp + " 입니다.");

    }


}
