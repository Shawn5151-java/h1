package tw.brad.h1.tutor;

import tw.brad.h1.dao.SCDao;
import tw.brad.h1.entity.Course;
import tw.brad.h1.entity.Student;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Lab16 {
	public static void main(String[] args) {
		SCDao dao = new SCDao();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Student ID:");
		long sid = scanner.nextLong();
		Student s1 = dao.getStudentById(sid);

		// 安全檢查
		if (s1 == null) {
			System.out.println("查無此人");
			return;
		}

		System.out.printf("Welcome, %s\n", s1.getSname());

		// 1. 修正：加上迴圈，這樣才能一直選課，break 也是合法的
		while (true) {
			System.out.println("----- 可選課程 -----");
			List<Course> courses = dao.getAllCourse();

			for (Course course : courses) {
				// 2. 修正邏輯：加上 ! (反向)，只列出還沒修過的課
				if (!isExist(s1, course.getStudents())) {
					System.out.printf("%d. %s\n", course.getId(), course.getCname());
				}
			}

			System.out.println("-----");
			System.out.println("Which? (0: for EXIT)");
			long cid = scanner.nextLong();

			// 3. 這裡 break 現在合法了，因為在 while 裡面
			if (cid <= 0) break;

			Course selectedCourse = dao.getCourseById(cid);
			if (selectedCourse != null) {
				s1.addCourse(selectedCourse);
				dao.update(s1);
				System.out.println("選課成功！");
			} else {
				System.out.println("課程 ID 輸入錯誤");
			}
		}
	}

	static boolean isExist(Student s, Set<Student> students) {
		// 4. 修正：加上 return
		return students.stream().anyMatch(student -> student.getId().equals(s.getId()));
	}
}