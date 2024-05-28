import { AutoMap } from '@automapper/classes';
import { Column, Entity } from 'typeorm';
import { DocumentBase } from 'src/components/base/document.base';
import { ApiProperty } from '@nestjs/swagger';
import {
    IsNotEmpty,
    IsString,
    MaxLength
} from 'class-validator';

@Entity({ name: 'questions' })
export class QuestionDocument extends DocumentBase {

    @ApiProperty({
        description: "question",
        example: "question",
        nullable: false,
        maxLength: 2000
    })
    @AutoMap()
    @Column()
    @IsNotEmpty()
    @IsString()
    @MaxLength(2000)
    question: string;
}

