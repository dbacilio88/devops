import { AutoMap } from "@automapper/classes";
import { ApiProperty } from "@nestjs/swagger";
import { IsBoolean, IsString } from "class-validator";
import { DtoBase } from "src/components/base/dto.base";

export class AnswerDto extends DtoBase {


    @IsString()
    @ApiProperty({
        description: 'answer',
        example: 'answer',
        nullable: true,
        uniqueItems: true,
        maxLength: 2000,
    })
    @AutoMap()
    answer: string

    @IsBoolean()
    @ApiProperty({
        description: 'correct',
        example: 'correct',
        nullable: true,
        default: true
    })
    @AutoMap()
    correct: boolean

}