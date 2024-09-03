<?php

namespace App\Database\Migrations;

use CodeIgniter\Database\Migration;

class CreateUsersAndErrorsTables extends Migration
{
    public $defaultGroup = 'default';

    public function up()
    {
        // Users table
        $this->forge->addField([
            'id' => [
                'type' => 'INT',
                'constraint' => 11,
                'unsigned' => true,
                'auto_increment' => true
            ],
            'username' => [
                'type' => 'VARCHAR',
                'constraint' => '100',
            ],
            'contact_type' => [
                'type' => 'VARCHAR',
                'constraint' => '50',
            ],
            'contact_info' => [
                'type' => 'VARCHAR',
                'constraint' => '100',
            ],
            'timestamp' => [
                'type' => 'DATETIME',
                'null' => false,
            ],
        ]);
        $this->forge->addKey('id', true);
        $this->forge->createTable('users');

        // Errors table
        $this->forge->addField([
            'id' => [
                'type' => 'INT',
                'constraint' => 11,
                'unsigned' => true,
                'auto_increment' => true
            ],
            'message' => [
                'type' => 'TEXT',
                'null' => false,
            ],
            'timestamp' => [
                'type' => 'DATETIME',
                'null' => false,
            ],
        ]);
        $this->forge->addKey('id', true);
        $this->forge->createTable('errors');
    }

    public function down()
    {
        $this->forge->dropTable('users');
        $this->forge->dropTable('errors');
    }
}