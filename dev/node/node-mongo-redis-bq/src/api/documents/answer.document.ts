import { AutoMap } from '@automapper/classes';
import { Column, Entity } from 'typeorm';
import { DocumentBase } from 'src/components/base/document.base';
import { ApiProperty } from '@nestjs/swagger';
import {
    IsBoolean,
    IsNotEmpty,
    IsString,
    MaxLength
} from 'class-validator';

@Entity({ name: 'answers' })
export class AnswerDocument extends DocumentBase {

    @ApiProperty({
        description: "answer",
        example: "answer",
        nullable: false,
        maxLength: 2000
    })
    @AutoMap()
    @Column()
    @IsNotEmpty()
    @IsString()
    @MaxLength(2000)
    answer: string;

    @ApiProperty({
        description: "correct",
        example: "correct",
        nullable: false,
        default: true
    })
    @AutoMap()
    @Column()
    @IsNotEmpty()
    @IsBoolean()
    correct: boolean;

  /*   @JoinColumn({ name: 'question_id' })
    @ManyToOne(type => QuestionDocument, question => question.answers,
        { onDelete: 'CASCADE', nullable: false }
    )
    question: QuestionDocument; */
}

