package com.urise.webapp.storage;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume1 = new Resume("Григорий Кислин");

        Map<ContactType, String> contact1 = resume1.getContacts();

        contact1.put(ContactType.PHONE, "+7(921) 855-0482");
        contact1.put(ContactType.SKYPE, "skype:grigory.kislin");
        contact1.put(ContactType.MAIL, "gkislin@yandex.ru");
        contact1.put(ContactType.LINKEDIN, "");
        contact1.put(ContactType.GITHUB, "");
        contact1.put(ContactType.STACKOVERFLOW, "");
        contact1.put(ContactType.HOMEPAGE, "");

        TextSection text1 = new TextSection();
        text1.setText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");

        TextSection text2 = new TextSection();
        text2.setText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и " +
                "архитектуры.");

        ListSection list1 = new ListSection();
        list1.setListAchievement("Организация команды и успешная реализация Java проектов для сторонних заказчиков: " +
                "приложения автопарк на стеке" + "\n" + "Spring Cloud/микросервисы, система мониторинга показателей " +
                "спортсменов на Spring Boot, участие в проекте МЭШ" + "\n" + "на Play-2, многомодульный Spring Boot " +
                "Vaadin проект для комплексных DIY смет." + "\n");
        list1.setListAchievement("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven.+" + "\n" + "Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\"." + "\n" + "Организация онлайн стажировок и ведение проектов. " +
                "Более 3500 выпускников." + "\n");
        list1.setListAchievement("Реализация двухфакторной аутентификации для онлайн платформы управления проектами " +
                "Wrike. Интеграция с" + "\n" + "Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk." + "\n");
        list1.setListAchievement("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. " +
                "Интеграция с 1С, Bonita" + "\n" + "BPM, CMIS, LDAP. Разработка приложения управления окружением на " +
                "стеке: Scala/Play/Anorm/JQuery." + "\n" + "Разработка SSO аутентификации и авторизации различных ERP " +
                "модулей, интеграция CIFS/SMB java сервера." + "\n");
        list1.setListAchievement("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, " +
                "Spring, Spring-MVC, GWT, ExtGWT" + "\n" + "(GXT), Commet, HTML5, Highstock для алгоритмического " +
                "трейдинга." + "\n");
        list1.setListAchievement("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных " +
                "сервисов (SOA-base" + "\n" + "архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и " +
                "информации о состоянии через систему" + "\n" + "мониторинга Nagios. Реализация онлайн клиента для " +
                "администрирования и мониторинга системы по JMX (Jython/ Django)." + "\n");
        list1.setListAchievement("Реализация протоколов по приему платежей всех основных платежных системы России " +
                "(Cyberplat, Eport, Chronopay," + "\n" + "Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        ListSection list2 = new ListSection();
        list2.setListAchievement("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2" + "\n");
        list2.setListAchievement("Version control: Subversion, Git, Mercury, ClearCase, Perforce" + "\n");
        list2.setListAchievement("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, " +
                "SQLite, MS SQL, HSQLDB" + "\n");
        list2.setListAchievement("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy" + "\n");
        list2.setListAchievement("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts" + "\n");
        list2.setListAchievement("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, " +
                "Spring (MVC, Security, Data, Clouds, Boot), " + "\n" + "JPA (Hibernate, EclipseLink), Guice, " +
                "GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse" + "\n" + "SWT, JUnit, " +
                "Selenium (htmlelements)." + "\n");
        list2.setListAchievement("Python: Django." + "\n");
        list2.setListAchievement("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js" + "\n");
        list2.setListAchievement("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka" + "\n");
        list2.setListAchievement("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, " +
                "SAX, DOM, XSLT, MDB, JMX," + "\n" + " JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, " +
                "BPMN2, LDAP, OAuth1, OAuth2, JWT." + "\n");
        list2.setListAchievement("Инструменты: Maven + plugin development, Gradle, настройка Ngnix" + "\n");
        list2.setListAchievement("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, " +
                "Nagios, iReport, OpenCmis, Bonita," + "\n" + " pgBouncer" + "\n");
        list2.setListAchievement("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, " +
                "архитектурных шаблонов," + "\n" + "UML, функционального программирования" + "\n");
        list2.setListAchievement("Родной русский, английский \"upper intermediate\"" + "\n");

        OrganizationSection orgSection1 = new OrganizationSection();

        OrganizationSection.Period period1 = new OrganizationSection.Period(new StringBuilder("Автор проекта"),
                LocalDate.of(2013, 10, 1), LocalDate.now());
        period1.setDescription(new StringBuilder("Создание, организация и проведение Java онлайн проектов и стажировок."));

        OrganizationSection.Organization organization1 = new OrganizationSection.Organization("Java Online Projects",
                period1);

        OrganizationSection.Period period2 = new OrganizationSection.Period(new StringBuilder("Старший разработчик (backend)"),
                LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1, 1));
        period2.setDescription(new StringBuilder("Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, " +
                "\n" + "Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, " + "\n" +
                "авторизация по OAuth1, OAuth2, JWT SSO."));

        OrganizationSection.Organization organization2 = new OrganizationSection.Organization("Wrike", period2);

        OrganizationSection.Period period3 = new OrganizationSection.Period(new StringBuilder("Java архитектор"),
                LocalDate.of(2012, 4, 1), LocalDate.of(2014, 10, 1));
        period3.setDescription(new StringBuilder("Организация процесса разработки системы ERP для разных окружений: релизная политика, " +
                "\n" + "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway)," + "\n" +
                "конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части" + "\n" +
                "системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего " +
                "назначения" + "\n" + "(почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online" + "\n" +
                "редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache" + "\n" +
                "Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, " + "\n" +
                "Unix shell remote scripting via ssh tunnels, PL/Python" + "\n"));

        OrganizationSection.Organization organization3 = new OrganizationSection.Organization("RIT Center",
                period3);

        OrganizationSection.Period period4 = new OrganizationSection.Period(new StringBuilder("Ведущий программист"),
                LocalDate.of(2010, 12, 1), LocalDate.of(2012, 4, 1));
        period4.setDescription(new StringBuilder("Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, " +
                "Spring MVC," + "\n" + "SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM." +
                "Реализация RIA-приложения для " + "\n" + " администрирования, мониторинга и анализа результатов в области " +
                "алгоритмического трейдинга. JPA, Spring," + "\n" + " Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, " +
                "HTML5."));

        OrganizationSection.Organization organization4 = new OrganizationSection.Organization("Luxoft (Deutsche Bank)",
                period4);

        OrganizationSection.Period period5 = new OrganizationSection.Period(new StringBuilder("Ведущий специалист"),
                LocalDate.of(2008, 6, 1), LocalDate.of(2012, 10, 1));
        period5.setDescription(new StringBuilder("Дизайн и имплементация Java EE фреймворка для отдела \"Платежные " +
                "Системы\" " + "\n" + "(GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация" + "\n" + "администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента " +
                "(Python/ Jython, Django, ExtJS)"));

        OrganizationSection.Organization organization5 = new OrganizationSection.Organization("Yota",
                period5);

        OrganizationSection.Period period6 = new OrganizationSection.Period(new StringBuilder("Разработчик ПО"),
                LocalDate.of(2007, 3, 1), LocalDate.of(2008, 6, 1));
        period6.setDescription(new StringBuilder("Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, " +
                "Hibernate 3.0," + "\n" + " Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));

        OrganizationSection.Organization organization6 = new OrganizationSection.Organization("Enkata",
                period6);

        OrganizationSection.Period period7 = new OrganizationSection.Period(new StringBuilder("Разработчик ПО"),
                LocalDate.of(2005, 1, 1), LocalDate.of(2007, 2, 1));
        period7.setDescription(new StringBuilder("Разработка информационной модели, проектирование интерфейсов, " +
                "реализация и" + "\n" + " отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));

        OrganizationSection.Organization organization7 = new OrganizationSection.Organization("Siemens AG",
                period7);

        OrganizationSection.Period period8 = new OrganizationSection.Period(new StringBuilder("Инженер по аппаратному " +
                "и программному тестированию"),
                LocalDate.of(1997, 9, 1), LocalDate.of(2005, 1, 1));
        period8.setDescription(new StringBuilder("Тестирование, отладка, внедрение ПО цифровой телефонной " +
                "станции Alcatel 1000 S12 (CHILL, ASM)."));

        OrganizationSection.Organization organization8 = new OrganizationSection.Organization("Alcatel",
                period8);

        orgSection1.setOrganizations(organization1, organization2, organization3, organization4, organization5,
                organization6, organization7, organization8);

        OrganizationSection orgSection2 = new OrganizationSection();

        OrganizationSection.Period period9 = new OrganizationSection.Period(new StringBuilder("'Functional Programming " +
                "Principles in Scala' by Martin Odersky"),
                LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1));
        OrganizationSection.Organization organization9 = new OrganizationSection.Organization("Coursera",
                period9);

        OrganizationSection.Period period10 = new OrganizationSection.Period(new StringBuilder("Курс 'Объектно-" +
                "ориентированный анализ ИС. Концептуальное моделирование на UML.'"),
                LocalDate.of(2011, 3, 1), LocalDate.of(2011, 4, 1));
        OrganizationSection.Organization organization10 = new OrganizationSection.Organization("Luxoft",
                period10);

        OrganizationSection.Period period11 = new OrganizationSection.Period(new StringBuilder("3 месяца обучения " +
                "мобильным IN сетям (Берлин)"),
                LocalDate.of(2005, 1, 1), LocalDate.of(2005, 4, 1));
        OrganizationSection.Organization organization11 = new OrganizationSection.Organization("Siemens AG",
                period11);

        OrganizationSection.Period period12 = new OrganizationSection.Period(new StringBuilder("6 месяцев обучения " +
                "цифровым телефонным сетям (Москва)"),
                LocalDate.of(1997, 9, 1), LocalDate.of(1998, 3, 1));
        OrganizationSection.Organization organization12 = new OrganizationSection.Organization("Alcatel",
                period12);

        OrganizationSection.Period period13 = new OrganizationSection.Period(new StringBuilder("Аспирантура " +
                "(программист С, С++)"),
                LocalDate.of(1993, 9, 1), LocalDate.of(1996, 7, 1));
        OrganizationSection.Organization organization13 = new OrganizationSection.Organization("Санкт-Петербургский" +
                " национальный исследовательский университет информационных технологий, механики и оптики",
                period13);

        OrganizationSection.Period period14 = new OrganizationSection.Period(new StringBuilder("Закончил с отличием"),
                LocalDate.of(1984, 9, 1), LocalDate.of(1987, 6, 1));
        OrganizationSection.Organization organization14 = new OrganizationSection.Organization("Заочная физико-" +
                "техническая школа при МФТИ",
                period14);

        orgSection2.setOrganizations(organization9, organization10, organization11, organization12, organization13,
                organization14);

        Map<SectionType, AbstractSection> sections1 = resume1.getSections();

        sections1.put(SectionType.OBJECTIVE, text1);
        sections1.put(SectionType.PERSONAL, text2);
        sections1.put(SectionType.ACHIEVEMENT, list1);
        sections1.put(SectionType.QUALIFICATIONS, list2);
        sections1.put(SectionType.EXPERIENCE, orgSection1);
        sections1.put(SectionType.EDUCATION, orgSection2);


        resume1.showResume();


    }
}
