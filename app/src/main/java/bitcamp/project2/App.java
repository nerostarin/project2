/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.project2;

import bitcamp.project2.util.Calender;
import bitcamp.project2.util.Prompt;
import bitcamp.project2.command.ToDoListCommand;

public class App {
    Calender calender = new Calender();
    String[] mainMenu = new String[]{"일정 추가", "일정 확인", "일정 변경", "일정 삭제", "달력 확인", "종료"};
    public static void main(String[] args) {
      /*  String underlineText = "\033[4mThis text is underlined\033[0m";
        String strikethroughText = "\033[9mThis text has strikethrough\033[0m";

        System.out.println(underlineText);
        System.out.println(strikethroughText);*/

        new App().loading();
    }

    //메인로딩
    void loading() {
        calender.settingCalender();//달력 세팅
        ToDoListCommand toDoListCommand = new ToDoListCommand();
        String command;
        printMainMenu();
        while (true) {
            try {
                command = Prompt.input("메인 > ");
                if (command.equals("메뉴") || command.equals("menu")) {
                    printMainMenu();
                }else {
                    int menuNumber = Integer.parseInt(command);
                    String menuTitle = getMenuTitle(mainMenu, menuNumber);
                    if (menuTitle == null) {
                        System.out.println("유효한 숫자를 입력 해주세요.");
                        continue;
                    }
                    else if (menuTitle.equals("종료"))
                    {
                        break;
                    }
                    switch (menuTitle) {
                        case "일정 추가":
                            toDoListCommand.addSchedule();
                            break;
                        case "일정 확인":
                            toDoListCommand.listCheck();
                            break;
                        case "일정 변경":
                            System.out.println(menuTitle);
                            break;
                        case "일정 삭제":
                            System.out.println(menuTitle);
                            break;
                        case "달력 확인":
                            Calender.promptAndShowCalendar();
                            break;
                        default:
                            System.out.println("유효하지않은 메인메뉴 번호입니다. 다시 입력해주세요");
                    }
                }
            }catch (NumberFormatException e)
            {
                System.out.println("문자 입력은 menu 만 가능합니다. 다시 입력해주세요");
            }
        }
        Prompt.close();
    }

    // 메뉴타이틀 추출 메서드
    String getMenuTitle(String[] menu, int menuNumber ) {
        return validation(menu, menuNumber) ? menu[menuNumber-1] : null;
    }

    // 입력값 유효판별 메서드
    Boolean validation(String[] menu, int menuNumber)
    {
        return menuNumber >= 1 && menuNumber <= menu.length;
    }

    // 메인 메뉴목록 출력 메서드
   public void printMainMenu()
    {
        System.out.println("========== 메뉴 ===========");
        for(int i = 0; i < mainMenu.length; i++)
        {
            System.out.printf("  %d  |  %s\n", i+1,mainMenu[i]);
        }
        System.out.println("===========================");
    }

}
