import { AutoMap } from "@automapper/classes";
import { ApiProperty } from "@nestjs/swagger";
import { IsString } from "class-validator";
import { DtoBase } from "src/components/base/dto.base";

export class QuestionDto extends DtoBase {


    @IsString()
    @ApiProperty({
        description: 'name',
        example: 'name',
        nullable: true,
        uniqueItems: true,
        maxLength: 2000,
    })
    @AutoMap()
    question: string

}