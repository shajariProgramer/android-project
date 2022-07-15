package com.example.newapplocation.domain.entities;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {

//    @Provides
//    @Singleton
//    CustomerRepository provideCustomerRepository(PazhService pazhService,
//                                                 CustomerDataSource customerDataSource) {
//        return new CustomerRepository(pazhService, customerDataSource);
//    }

//    @Provides
//    @Singleton
//    MenuRepository provideMenuRepository(ApiService apiService,
//                                         CustomerRepository customerRepository,
//                                         MenuDataSource menuDataSource) {
//        return new MenuRepository(apiService, menuDataSource, customerRepository);
//    }

//    @Provides
//    @Singleton
//    UserRepository provideUserManager(ApiService apiService,
//                                      PazhService pazhService,
//                                      UserDataSource userDataSource,
//                                      AuthorizationInterceptor authorizationInterceptor,
//                                      MenuDataSource menuDataSource,
//                                      SettingDataSource settingDataSource,
//                                      FinanceCycleDataSource financeCycleDataSource,
//                                      SystemChartDataSource systemChartDataSource, PersonDataSource mPersonDataSource) {
//        return new UserRepository(apiService, pazhService, userDataSource, authorizationInterceptor,
//                settingDataSource, menuDataSource, financeCycleDataSource,
//                systemChartDataSource, mPersonDataSource);
//    }

//    @Provides
//    @Singleton
//    PostRepository providePostRepository(ApiService apiService,
//                                         PostDataSource postDataSource,
//                                         AuthorizationInterceptor authorizationInterceptor) {
//        return new PostRepository(apiService, postDataSource, authorizationInterceptor);
//    }

//    @Provides
//    @Singleton
//    TimeCardRepository provideTimeCardRepository(ApiService apiService) {
//        return new TimeCardRepository(apiService);
//    }

//    @Provides
//    @Singleton
//    KartableRepository provideKartableRepository(ApiService apiService) {
//        return new KartableRepository(apiService);
//    }

//    @Provides
//    @Singleton
//    DomainRepository provideDomainRepository(ApiService apiService, AppDatabaseManager appDatabaseManager) {
//        return new DomainRepository(apiService, appDatabaseManager);
//    }

//    @Provides
//    @Singleton
//    EmploymentCertificateRepository provideEmploymentCertificateRepository(ApiService apiService) {
//        return new EmploymentCertificateRepository(apiService);
//    }

//    @Provides
//    @Singleton
//    PropertiesRepository providePropertiesRepository(ApiService apiService) {
//        return new PropertiesRepository(apiService);
//    }

//    @Provides
//    @Singleton
//    RequestRepository provideRequestRepository(ApiService apiService) {
//        return new RequestRepository(apiService);
//    }

//    @Provides
//    @Singleton
//    PayrollRepository providePayrollRepository(ApiService apiService,
//                                               @Named("PayrollCache") String temporaryPath) {
//        return new PayrollRepository(apiService, temporaryPath);
//    }

//    @Provides
//    @Singleton
//    WarrantRepository provideWarrantRepository(ApiService apiService,
//                                               @Named("WarrantCache") String temporaryPath) {
//        return new WarrantRepository(apiService, temporaryPath);
//    }
//
//    @Provides
//    @Singleton
//    PrescriptionRepository providePrescriptionRepository(ApiService apiService) {
//        return new PrescriptionRepository(apiService);
//    }
//
//    @Provides
//    @Singleton
//    UpdateRepository provideUpdateRepository(PazhService pazhService) {
//        return new UpdateRepository(pazhService);
//    }
//
//    @Provides
//    @Singleton
//    LetterRepository provideLetterRepository(ApiService apiService) {
//        return new LetterRepository(apiService);
//    }
//
//
//    @Provides
//    @Singleton
//    SupervisionsRepository provideSupervisionRepository(ApiService apiService,
//                                                        SupervisionDataSource mDataSource) {
//        return new SupervisionsRepository((apiService), mDataSource);
//    }
//
//
//    @Provides
//    @Singleton
//    NotificationRepository provideNotificationRepository(ApiService apiService) {
//        return new NotificationRepository(apiService);
//    }
//
//    @Provides
//    @Singleton
//    RetireesRepository provideRetireesRepository(ApiService apiService) {
//        return new RetireesRepository(apiService);
//    }
//
//    @Provides
//    @Singleton
//    @Named("PersonPictureCache")
//    String providePictureCatch(@Named("AppPath") String appPath) {
//        File appDir = new File(appPath, "PicCache");
//        if (appDir.exists()) {
//            return appDir.getAbsolutePath();
//        }
//        if (appDir.mkdir()) {
//            return appDir.getAbsolutePath();
//        }
//        return appPath;
//    }
//
//    @Provides
//    @Singleton
//    @Named("VersionPath")
//    String provideAppVersionPath(@Named("AppPath") String appPath) {
//        File appDir = new File(appPath, "versions");
//        if (appDir.exists()) {
//            return appDir.getAbsolutePath();
//        }
//        if (appDir.mkdir()) {
//            return appDir.getAbsolutePath();
//        }
//        return appPath;
//    }
//
//    @Provides
//    @Singleton
//    @Named("PayrollCache")
//    String providePayrollCache(@Named("AppPath") String appPath) {
//        File appDir = new File(appPath, "PCache");
//        if (appDir.exists()) {
//            return appDir.getAbsolutePath();
//        }
//        if (appDir.mkdir()) {
//            return appDir.getAbsolutePath();
//        }
//        return appPath;
//    }
//
//    @Provides
//    @Singleton
//    @Named("WarrantCache")
//    String provideWarrantCache(@Named("AppPath") String appPath) {
//        File appDir = new File(appPath, "WCache");
//        Log.d(DomainModule.class.getSimpleName(), appDir.getAbsolutePath());
//        if (appDir.exists()) {
//            return appDir.getAbsolutePath();
//        }
//        if (appDir.mkdir()) {
//            return appDir.getAbsolutePath();
//        }
//        return appPath;
//    }
//
//    @Provides
//    @Singleton
//    @Named("AttachmentCache")
//    String provideAttachmentCache(@Named("AppPath") String appPath) {
//        File appDir = new File(appPath, "ACache");
//        if (appDir.exists()) {
//            return appDir.getAbsolutePath();
//        }
//        if (appDir.mkdir()) {
//            return appDir.getAbsolutePath();
//        }
//        return appPath;
//    }
//
//    @Provides
//    @Singleton
//    @Named("PortalCache")
//    String providePortalCache(@Named("AppPath") String appPath) {
//        File appDir = new File(appPath, "PortalDownloader");
//        if (appDir.exists()) {
//            return appDir.getAbsolutePath();
//        }
//        if (appDir.mkdir()) {
//            return appDir.getAbsolutePath();
//        }
//        return appPath;
//    }
}
