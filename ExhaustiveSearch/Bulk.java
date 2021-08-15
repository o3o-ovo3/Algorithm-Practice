// 백준 알고리즘 브루트포스 - 덩치
// 실패한 코드

package baekjoon.brute;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Person{
    int height;
    int weight;
    int rank;

    public Person(int height, int weight, int rank){
        this.height = height;
        this.weight = weight;
        this.rank = rank;
    }
}

public class Bulk {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Person[] people = new Person[N];
        Person max = null;
        int idx = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            if(i == 0){
                people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
                max = people[i];
            }

            else{
                Person person = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
                if(person.height > max.height && person.weight > max.weight){
                    person.rank = 1;
                    max = person;
                    people[i] = person;

                    while(idx < i){
                        people[idx].rank += 1;
                        idx++;
                    }
                } else {
                    while(idx < i){
                        if(people[idx].height > person.height && people[idx].weight > person.weight) {
                            idx++;
                            if(idx == i){
                                person.rank = i + 1;
                                people[i] = person;
                            }
                            continue;
                        } else{
                            person.rank = people[idx].rank;
                            people[i] = person;
                            int index = 0;
                            while(index < i){
                                if(people[index].rank > person.rank){
                                    people[index].rank ++;
                                }
                                index++;
                            }
                            break;
                        }
                    }
                }
                idx = 0;
            }
        }
        for(Person p : people){
            System.out.print(p.rank + " ");
        }
    }
}
