package com.example.spring20240924.api;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Map;

@RestController
@RequestMapping("/api/main8")
public class ApiController8 {

    // POST 요청을 처리하는 메서드
    @PostMapping("sub1")
    public void method1(@RequestParam String city,   // 클라이언트로부터 받은 'city' 파라미터
                        @RequestParam String country, // 클라이언트로부터 받은 'country' 파라미터

                        // 업로드되는 파일을 MultipartFile로 처리
                        @RequestParam MultipartFile file) {

        // 클라이언트로부터 받은 'city'와 'country' 값 출력
        System.out.println("city = " + city);
        System.out.println("country = " + country);

        // 업로드된 파일의 이름을 출력
        System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());

        // 업로드된 파일의 크기를 출력
        System.out.println("file.getSize() = " + file.getSize());

        // 파일 저장 처리
        try {
            // 파일을 읽기 위한 InputStream을 얻음
            //InputStream : 메모리나 파일 시스템에서 읽어오기 위한 경로를 제공
            InputStream is = file.getInputStream();
            // BufferedInputStream을 사용하여 효율적인 파일 읽기 처리
            BufferedInputStream bis = new BufferedInputStream(is);

            // 파일을 저장할 경로 지정 (C:/Temp/에 파일 저장)
            String outputFilePath = "C:/Temp/" + file.getOriginalFilename();
            // 출력 스트림 생성 (지정된 경로에 파일을 저장하기 위한 FileOutputStream)
            FileOutputStream fos = new FileOutputStream(outputFilePath);
            // BufferedOutputStream을 사용하여 효율적인 파일 쓰기 처리
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            // 자원 관리를 위한 try-with-resources 구문 사용
            try (bis; bos; fos; is;) {
                byte[] buffer = new byte[1024];  // 1KB씩 읽을 버퍼 생성
                int length;
                // 파일을 1KB씩 읽어 BufferedOutputStream으로 씀
                while ((length = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, length);  // 읽은 데이터를 파일에 씀
                }
                // 데이터를 모두 쓴 후, 출력 스트림을 플러시하여 데이터를 저장
                bos.flush();
            }

        } catch (Exception e) {
            // 예외 발생 시 RuntimeException으로 던짐
            throw new RuntimeException(e);
        }

    }

    @PostMapping("sub2")
    public void method2(@RequestParam String title,
                        @RequestParam MultipartFile attached) throws IOException {
        System.out.println("title = " + title);
        System.out.println("attached = " + attached.getOriginalFilename());

        attached.transferTo(new File("C:/Temp/" + attached.getOriginalFilename()));

    }

    @PostMapping("sub3")
    public void method3(@RequestParam String title,
                        @RequestParam(name = "files[]") MultipartFile[] attached) throws IOException {
        // 향상된 for문
        for (MultipartFile file : attached) {
            file.transferTo(new File("C:/Temp/" + file.getOriginalFilename()));
            //getOriginalFilename :MultipartFile의 메서드
        }

    }
}
/*
1. 어노테이션 (Annotations)
어노테이션은 Java 코드에 메타데이터를 추가하는 데 사용되며, 주로 Spring에서 요청을 처리하는 데 중요한 역할을 합니다.

@RestController
기능: 해당 클래스가 RESTful 웹 서비스의 컨트롤러임을 나타냅니다. 이 클래스는 HTTP 요청을 처리하는 메서드를 포함하고 있습니다. 반환 값은 주로 HTTP 응답 본문으로 자동 변환됩니다.

@RequestMapping("/api/main8")
기능: 해당 클래스 또는 메서드가 처리하는 HTTP 요청의 기본 경로를 지정합니다. 이 어노테이션을 사용하면 클래스 레벨에서 기본 경로를 설정할 수 있습니다. /api/main8으로 시작하는 요청을 처리하는 메서드를 정의합니다.

@PostMapping("sub1"), @PostMapping("sub2"), @PostMapping("sub3")
기능: HTTP POST 요청을 처리하는 메서드를 정의합니다. 각각 sub1, sub2, sub3 경로로 오는 POST 요청을 처리합니다.

@RequestParam
기능: HTTP 요청에서 특정 파라미터를 메서드의 인자에 바인딩합니다. 클라이언트로부터 전달된 데이터를 메서드 인자로 받을 수 있게 해줍니다.

@RequestParam String city: 클라이언트가 전송한 city 파라미터 값을 city 변수로 받습니다.
@RequestParam MultipartFile file: 클라이언트가 업로드한 파일을 MultipartFile 객체로 받습니다.

@RequestParam(name = "files[]")
기능: 여러 파일을 배열로 받기 위한 어노테이션입니다. 클라이언트에서 files[]라는 이름으로 파일들을 보내면, 이를 MultipartFile[] 배열로 받을 수 있습니다.
2. 함수 (Functions)
함수는 일반적으로 특정 작업을 수행하기 위해 작성된 코드 블록을 의미합니다. 이 코드에서는 주로 HTTP 요청을 처리하는 메서드를 의미합니다.

method1 (@PostMapping("sub1")에 해당하는 메서드)

기능: 클라이언트로부터 city, country, 파일을 받아서, 파일을 지정된 경로(C:/Temp/)에 저장하는 역할을 합니다.
작업:
city, country 값을 출력
업로드된 파일의 이름과 크기를 출력
파일을 읽어서 C:/Temp/ 경로에 저장
method2 (@PostMapping("sub2")에 해당하는 메서드)

기능: title과 파일을 받아서, 파일을 C:/Temp/ 경로에 저장하는 역할을 합니다.
작업:
title 값 출력
업로드된 파일을 C:/Temp/ 경로에 저장 (transferTo 메서드 사용)
method3 (@PostMapping("sub3")에 해당하는 메서드)

기능: 여러 파일을 받아서 각 파일을 C:/Temp/ 경로에 저장하는 역할을 합니다.
작업:
여러 파일을 받아서 각각 C:/Temp/ 경로에 저장 (transferTo 메서드 사용)
3. 메서드 (Methods)
메서드는 객체가 가진 기능을 정의하는 코드 블록입니다. 각 메서드는 특정 작업을 수행하며, Java에서는 객체에 속한 함수의 형태입니다.

file.getOriginalFilename()

기능: 업로드된 파일의 원래 이름을 반환합니다. 예를 들어, 클라이언트가 업로드한 파일의 이름을 알 수 있습니다.
file.getSize()

기능: 업로드된 파일의 크기를 바이트 단위로 반환합니다.
file.getInputStream()

기능: 업로드된 파일을 읽기 위한 InputStream 객체를 반환합니다. 이 스트림을 통해 파일 데이터를 읽을 수 있습니다.
bis.read(buffer)

기능: BufferedInputStream을 사용하여 파일 데이터를 buffer 배열에 읽어들입니다. 파일에서 데이터를 버퍼 크기만큼 한 번에 읽습니다.
bos.write(buffer, 0, length)

기능: BufferedOutputStream을 사용하여 읽은 데이터를 지정된 길이만큼 파일에 씁니다. 버퍼의 처음부터 length만큼 데이터를 출력합니다.
bos.flush()

기능: BufferedOutputStream에 남아있는 데이터를 모두 파일에 기록합니다. 버퍼에 쌓인 데이터를 강제로 디스크에 저장하기 위해 사용합니다.
file.transferTo(File)

기능: MultipartFile 객체의 내용을 지정된 File 객체로 바로 저장합니다. 이 메서드는 파일을 빠르게 저장하는 방법으로, BufferedOutputStream을 직접 사용할 필요 없이 파일에 데이터를 저장할 수 있습니다.
결론
어노테이션은 주로 클래스나 메서드에 설정을 추가하여 요청을 처리할 수 있도록 해줍니다.
함수는 HTTP 요청을 처리하는 논리적 코드 블록입니다.
메서드는 파일을 읽고 쓰거나 업로드된 파일을 다루는 세부 기능을 수행하는 코드입니다.
* */
