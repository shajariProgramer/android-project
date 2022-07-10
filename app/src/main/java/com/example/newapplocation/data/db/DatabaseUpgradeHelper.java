package com.example.newapplocation.data.db;

import android.content.Context;

import com.example.newapplocation.data.entities.DaoMaster;
import com.example.newapplocation.data.entities.FeatureEntityDao;
import com.example.newapplocation.data.entities.MessageEntityDao;
import com.example.newapplocation.data.entities.QuestionAnswerEntityDao;
import com.example.newapplocation.data.entities.QuestionnaireItemEntityDao;
import com.example.newapplocation.data.entities.SupervisionEntityDao;
import com.example.newapplocation.data.entities.SystemChartEntityDao;
import com.example.newapplocation.data.entities.UserEntityDao;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DatabaseUpgradeHelper extends DaoMaster.DevOpenHelper {
    public DatabaseUpgradeHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        List<Migration> migrations = getMigrations();
//         Only run migrations past the old version
        for (Migration migration : migrations) {
            if (oldVersion < migration.getVersion()) {
                migration.runMigration(db);
            }

        }
    }

    private List<Migration> getMigrations() {
        List<Migration> migrations = new ArrayList<>();
        migrations.add(new MigrationV2());
        Comparator<Migration> migrationComparator = new Comparator<Migration>() {
            @Override
            public int compare(Migration m1, Migration m2) {
                return m1.getVersion().compareTo(m2.getVersion());
            }
        };
        Collections.sort(migrations, migrationComparator);
        return migrations;
    }

    private static class MigrationV2 implements Migration {

        @Override
        public Integer getVersion() {
            return 2;
        }

        @Override
        public void runMigration(Database db) {
            db.execSQL("ALTER TABLE " + SystemChartEntityDao.TABLENAME + " ADD COLUMN " +
                    SystemChartEntityDao.Properties.Code.columnName + " TEXT");
        }
    }

    private static class MigrationV3 implements Migration {

        @Override
        public Integer getVersion() {
            return 3;
        }

        @Override
        public void runMigration(Database db) {
            SupervisionEntityDao.dropTable(db, true);
            QuestionnaireItemEntityDao.dropTable(db, true);
            QuestionAnswerEntityDao.dropTable(db, true);

            SupervisionEntityDao.createTable(db, true);
            QuestionnaireItemEntityDao.createTable(db, true);
            QuestionAnswerEntityDao.createTable(db, true);
        }
    }

    private static class MigrationV4 implements Migration {

        @Override
        public Integer getVersion() {
            return 4;
        }

        @Override
        public void runMigration(Database db) {
        }
    }

    private static class MigrationV5 implements Migration {

        @Override
        public Integer getVersion() {
            return 5;
        }

        @Override
        public void runMigration(Database db) {
            QuestionnaireItemEntityDao.dropTable(db, true);
            QuestionnaireItemEntityDao.createTable(db, true);
        }
    }

    private static class MigrationV6 implements Migration {

        @Override
        public Integer getVersion() {
            return 6;
        }

        @Override
        public void runMigration(Database db) {
            UserEntityDao.dropTable(db, true);
            UserEntityDao.createTable(db, true);
        }
    }

    private static class MigrationV7 implements Migration {

        @Override
        public Integer getVersion() {
            return 7;
        }

        @Override
        public void runMigration(Database db) {
            FeatureEntityDao.createTable(db, true);
        }
    }

    private static class MigrationV8 implements Migration {

        @Override
        public Integer getVersion() {
            return 8;
        }

        @Override
        public void runMigration(Database db) {
            MessageEntityDao.createTable(db, true);
        }
    }


    private interface Migration {
        Integer getVersion();

        void runMigration(Database db);
    }
}
