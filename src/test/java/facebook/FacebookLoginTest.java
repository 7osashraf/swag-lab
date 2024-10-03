package facebook;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;


import Utility.FindingElements;

public class FacebookLoginTest extends FindingElements{


	@BeforeTest
	public void setUp() {

		// Set Chrome options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-infobars");
		options.addArguments("start-maximized");
		options.addArguments("--disable-extensions");

		// Initialize WebDriver and WebDriverWait
		driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	}


	@Test
	public void testFacebookLogin() {
		try {
			// Open Facebook login page
			driver.get("https://www.facebook.com");

			// Wait for the email field to be visible and enter the email
			WebElement emailField = findElementById("email");
			explicitlyWaitForVisibility(emailField);
			//WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			emailField.sendKeys("ha3276217@gmail.com");

			// Wait for the password field to be visible and enter the password
			WebElement passField = findElementById("pass");
			explicitlyWaitForVisibility(passField);
			//WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));
			passField.sendKeys("ADMINadmin1");


			// Press Enter to log in
			WebElement buttonField = findElementByXPath("//button[@name='login']");
			buttonField.click();
			//passField.sendKeys(Keys.RETURN);

			// Wait for the home page to load after login (replace with actual wait condition as needed)
			Thread.sleep(5000);

			// Navigate to the target URL after login
			//driver.get("YOUR_TARGET_URL");

			String url = driver.getCurrentUrl();
			checkIfEqual(url, "https://www.facebook.com/checkpoint/1501092823525282/?next=https%3A%2F%2Fwww.facebook.com%2F");

			// Wait for the target page to load
			Thread.sleep(5000);

			// After successful login, execute the Unfold logic
			unfoldContent();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void unfoldContent() throws InterruptedException {
		int count = 0;
		boolean keepScrolling = true;
		int oldNumReviews = 0;
		int specifiedNumber = 999; // Number of reviews to get

		while (keepScrolling) {
			count++;

			// Opening comments and replies
			openComment();
			getBack();
			for (int i = 0; i < 3; i++) {
				openReply();
				getBack();
			}
			for (int i = 0; i < 3; i++) {
				openReply2();
				getBack();
			}

			// Expanding 'See More'
			openSeeMore();
			getBack();

			// Scroll to the bottom
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(5000); // Wait for posts to load

			// Process check
			List<WebElement> reviewList = driver.findElements(By.xpath("//div[@class='du4w35lb k4urcfbm l9j0dhe7 sjgh65i0']"));
			int numReviews = reviewList.size();
			if (oldNumReviews < numReviews) {
				System.out.println("Scroll Count: " + count + "  numReviews: " + numReviews);
			}
			oldNumReviews = numReviews;

			// Termination condition
			if (numReviews >= specifiedNumber) {
				archiveAtEnd(reviewList);
				keepScrolling = false;
			}
		}
	}

	// Method to open more comments
	public void openComment() throws InterruptedException {
		List<WebElement> moreComment = driver.findElements(By.xpath("//span[contains(@class,'d2edcug0 hpfvmrgz qv66sw1b c1et5uql oi732d6d ik7dh3pa ht8s03o8 a8c37x1j keod5gw0 nxhoafnm aigsh9s9 d9wwppkn fe6kdd0r mau55g9w c8b282yb iv3no6db jq4qci2q a3bd9o3v lrazzd5p m9osqain') and starts-with(text(), 'View') and contains(text(), 'more comment')]"));
		if (!moreComment.isEmpty()) {
			int count = 0;
			for (WebElement comment : moreComment) {
				try {
					new Actions(driver).moveToElement(comment).click().perform();
					count++;
				} catch (Exception e) {
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", comment);
						count++;
					} catch (Exception ex) {
						// Skip any remaining issues
					}
				}
			}
			if (moreComment.size() - count > 0) {
				System.out.println("moreComment issue: " + (moreComment.size() - count));
			}
			Thread.sleep(1000); // Wait a bit for content to load
		}
	}

	// Method to open replies (first type)
	public void openReply() throws InterruptedException {
		List<WebElement> replies = driver.findElements(By.xpath("//div[@class='rq0escxv l9j0dhe7 du4w35lb j83agx80 cbu4d94t pfnyh3mw d2edcug0 hpfvmrgz n8tt0mok hyh9befq r8blr3vg jwdofwj8 g0qnabr5']"));
		if (!replies.isEmpty()) {
			int count = 0;
			for (WebElement reply : replies) {
				try {
					new Actions(driver).moveToElement(reply).click().perform();
					count++;
				} catch (Exception e) {
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", reply);
						count++;
					} catch (Exception ex) {
						// Skip any remaining issues
					}
				}
			}
			if (replies.size() - count > 0) {
				System.out.println("replies issue: " + (replies.size() - count));
			}
			Thread.sleep(1000);
		}
	}

	// Method to open more replies (second type)
	public void openReply2() throws InterruptedException {
		List<WebElement> replies = driver.findElements(By.xpath("//span[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql oi732d6d ik7dh3pa ht8s03o8 a8c37x1j keod5gw0 nxhoafnm aigsh9s9 d9wwppkn fe6kdd0r mau55g9w c8b282yb iv3no6db jq4qci2q a3bd9o3v lrazzd5p m9osqain' and contains(text(),'more repl')]"));
		if (!replies.isEmpty()) {
			int count = 0;
			for (WebElement reply : replies) {
				try {
					new Actions(driver).moveToElement(reply).click().perform();
					count++;
				} catch (Exception e) {
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", reply);
						count++;
					} catch (Exception ex) {
						// Skip any remaining issues
					}
				}
			}
			if (replies.size() - count > 0) {
				System.out.println("replies2 issue: " + (replies.size() - count));
			}
			Thread.sleep(1000);
		}
	}

	// Method to expand 'See More'
	public void openSeeMore() throws InterruptedException {
		List<WebElement> readMore = driver.findElements(By.xpath("//div[contains(@class,'oajrlxb2 g5ia77u1 qu0x051f esr5mh6w e9989ue4 r7d6kgcz rq0escxv nhd2j8a9 nc684nl6 p7hjln8o kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x jb3vyjys rz4wbd8a qt6c0cv9 a8nywdso i1ao9s8h esuyzwwr f1sip0of lzcic4wl oo9gr5id gpro0wi8 lrazzd5p') and contains(text(), 'See More')]"));
		if (!readMore.isEmpty()) {
			int count = 0;
			for (WebElement more : readMore) {
				try {
					new Actions(driver).moveToElement(more).click().perform();
					count++;
				} catch (Exception e) {
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", more);
						count++;
					} catch (Exception ex) {
						// Skip any remaining issues
					}
				}
			}
			if (readMore.size() - count > 0) {
				System.out.println("readMore issue: " + (readMore.size() - count));
			}
			Thread.sleep(1000);
		}
	}

	// Method to get back in case of redirection
	public void getBack() {
		if (!driver.getCurrentUrl().endsWith("reviews")) {
			System.out.println("redirected!!!");
			driver.navigate().back();
			System.out.println("got back!!!");
		}
	}

	// Method to archive at the end
	public void archiveAtEnd(List<WebElement> reviewList) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);"); // Scroll back to the top
		Thread.sleep(10000);

		for (int idx = 0; idx < reviewList.size(); idx++) {
			if (idx % 10 == 0) {
				if (idx < 15) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", reviewList.get(0));
				} else {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", reviewList.get(idx - 15));
				}

				Thread.sleep(1000);
				try {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", reviewList.get(idx + 15));
				} catch (Exception e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", reviewList.get(reviewList.size() - 1));
				}

				Thread.sleep(1000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", reviewList.get(idx));

				for (int r = 0; r < 2; r++) {
					Thread.sleep(3000);
					try {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", reviewList.get(idx + 5));
						Thread.sleep(3000);
					} catch (Exception e) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", reviewList.get(reviewList.size() - 1));
					}
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", reviewList.get(idx + r * 3));
					Thread.sleep(3000);
					// Save review content (placeholder for actual saving logic)
					System.out.println("Saving review: " + idx + "_" + r);
				}
			}
		}
	}
	
	public class DataExtractor {

	    public static void main(String[] args) throws IOException {
	        // Load HTML file
	        File input = new File("PATH TO FILE.html");
	        Document doc = Jsoup.parse(input, "UTF-8");

	        // Extract reviews
	        Elements reviews = doc.select("div.du4w35lb.k4urcfbm.l9j0dhe7.sjgh65i0");

	        List<String> ratings = new ArrayList<>();
	        List<String> users = new ArrayList<>();
	        List<String> usernames = new ArrayList<>();
	        List<String> texts = new ArrayList<>();
	        List<String> dates = new ArrayList<>();

	        for (Element r : reviews) {
	            // Extract Rating
	            Element ratingElement = r.selectFirst("h2.gmql0nx0.l94mrbxd.p1ri9a11.lzcic4wl.aahdfvyu.hzawbc8m");
	            if (ratingElement != null) {
	                String ratingText = ratingElement.text();
	                if (ratingText.contains("recommend")) {
	                    ratings.add(ratingText);
	                } else {
	                    ratings.add("no rating");
	                }
	            } else {
	                ratings.add("no rating");
	            }

	            // Extract User
	            Element userElement = r.selectFirst("a.oajrlxb2.g5ia77u1.qu0x051f.esr5mh6w.e9989ue4.r7d6kgcz");
	            if (userElement != null) {
	                users.add(userElement.text().trim());
	            } else {
	                users.add("no user");
	            }

	            // Extract Username
	            String username = userElement.attr("href").substring(25).split("\\?")[0];
	            if (username.equals("profile.php")) {
	                String userId = userElement.attr("href").split("\\?id=")[1].split("&")[0];
	                usernames.add(userId);
	            } else {
	                usernames.add(username);
	            }

	            // Extract Text
	            Element textElement = r.selectFirst("span.d2edcug0.hpfvmrgz.qv66sw1b");
	            if (textElement != null) {
	                texts.add(textElement.text().trim());
	            } else {
	                Element altTextElement = r.selectFirst("div.kvgmc6g5.cxmmr5t8.oygrvhab.hcukyx3x");
	                if (altTextElement != null) {
	                    texts.add(altTextElement.text().trim());
	                } else {
	                    texts.add("no text");
	                }
	            }

	            // Extract Date
	            Element dateElement = r.selectFirst("a.oajrlxb2.g5ia77u1.qu0x051f.esr5mh6w.e9989ue4");
	            if (dateElement != null) {
	                String date = dateElement.attr("aria-label");
	                if (date.contains("h")) {
	                    dates.add("October 1, 2021");
	                } else if (date.contains("d")) {
	                    int daysAgo = Integer.parseInt(date.split("d")[0]);
	                    String currentDate = "10/01/21";  // Example date, can be changed dynamically
	                    LocalDate dateObj = LocalDate.parse(currentDate, DateTimeFormatter.ofPattern("MM/dd/yy"))
	                        .minusDays(daysAgo);
	                    dates.add(dateObj.toString());
	                } else if (date.contains("2020") || date.contains("2019") || date.contains("2018")) {
	                    dates.add(date);
	                } else {
	                    dates.add(date.split(" ")[0] + " " + date.split(" ")[1] + ", 2021");
	                }
	            } else {
	                dates.add("no date");
	            }
	        }

	        // Example output
	        System.out.println("Ratings: " + ratings);
	        System.out.println("Users: " + users);
	        System.out.println("Usernames: " + usernames);
	        System.out.println("Texts: " + texts);
	        System.out.println("Dates: " + dates);
	    }
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit(); // Close the browser after the test
		}
	}



}
